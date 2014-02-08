package com.hlx.birdhouse.common.service.mk;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.InitializingBean;

import com.alibaba.common.lang.StringUtil;
import com.alibaba.common.logging.Logger;
import com.alibaba.common.logging.LoggerFactory;
import com.hlx.birdhouse.common.vo.BirdHouseVO;

/**
 * ��MKService.java��ʵ��������������
 * 
 * @author maxjcs 2013-9-11 ����4:50:39
 */
public class MKService implements InitializingBean,Runnable {

    private static final Logger logger = LoggerFactory.getLogger(MKService.class);
    
    private static boolean isStarted=false;

    @Resource
    private ChangeIpService4Adsl     changeIpService4Adsl;

    @Resource
    private ActionService       actionService;

    @Resource
    private ActionDBService           actionDBService;
    
    @Override
    public void run() {
        try {
            while (true) {
                // ��ȡ�µ���վ����
                BirdHouseVO vo = actionDBService.getNextWebSite();
                //���û���µ���������1���ӡ�
                if(vo==null){
                    Thread.currentThread().sleep(60*1000);
                    continue;
                }
                List<String> datafileList = actionService.createDataFile(vo);
                for(String datafile:datafileList){
                	// ��ȡ�µ�Ip
                    String newIP = changeIpService4Adsl.getNewIP();
                    if (StringUtil.isNotEmpty(newIP)) {
                       
                        actionService.runAction(datafile);
                        //����1���ӣ���ȥ�����û����ɡ�
                        while (!actionService.checkSuccess(datafile)) {
                            Thread.currentThread().sleep(100);
                        }
                        //���д��ʧ�ܣ���ֹ�߳�
                        boolean saveSuccess=actionDBService.record(vo, newIP);
                        if(!saveSuccess){
                            break;
                        }
                    }
                }
                
            }
        } catch (Exception ex) {
            logger.error("MKService.excute() is error!", ex);
        }
    }
    
    /**
     * ��������һ���߳�����������
     */
    public void start(){
        if(!isStarted){
            isStarted=true;
            logger.error("-------------------mkservice  to start() --hashcode: "+this.hashCode());
           Thread thread=new Thread(this);
           thread.start();
       }
    }

    /**
     * ��ʼ������������
     */
    @Override
    public void afterPropertiesSet() throws Exception {
       //this.start();
    }


}
