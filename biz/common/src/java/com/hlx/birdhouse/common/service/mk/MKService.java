package com.hlx.birdhouse.common.service.mk;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.InitializingBean;

import com.alibaba.common.lang.StringUtil;
import com.alibaba.common.logging.Logger;
import com.alibaba.common.logging.LoggerFactory;
import com.hlx.birdhouse.common.vo.BirdHouseVO;

/**
 * 类MKService.java的实现描述：调度类
 * 
 * @author maxjcs 2013-9-11 下午4:50:39
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
                // 获取新的网站任务
                BirdHouseVO vo = actionDBService.getNextWebSite();
                //如果没有新的任务，休眠1分钟。
                if(vo==null){
                    Thread.currentThread().sleep(60*1000);
                    continue;
                }
                List<String> datafileList = actionService.createDataFile(vo);
                for(String datafile:datafileList){
                	// 获取新的Ip
                    String newIP = changeIpService4Adsl.getNewIP();
                    if (StringUtil.isNotEmpty(newIP)) {
                       
                        actionService.runAction(datafile);
                        //休眠1秒钟，再去检查有没有完成。
                        while (!actionService.checkSuccess(datafile)) {
                            Thread.currentThread().sleep(100);
                        }
                        //如果写入失败，终止线程
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
     * 单独启动一个线程来运行任务
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
     * 初始化后，启动任务
     */
    @Override
    public void afterPropertiesSet() throws Exception {
       //this.start();
    }


}
