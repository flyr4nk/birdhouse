package com.hlx.birdhouse.common.service.mk;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;

import org.apache.commons.httpclient.util.DateUtil;

import com.alibaba.common.lang.StringUtil;
import com.alibaba.common.logging.Logger;
import com.alibaba.common.logging.LoggerFactory;

public abstract class BaseChangeIpService {

    private static final Logger logger   = LoggerFactory.getLogger(BaseChangeIpService.class);

    private String              getipUrl = "http://127.0.0.1:7001/home/getIp.do";
    
    /**
     * ��ȡ�µ�IP��ַ
     * @return
     */
    public  String getNewIP(){
        logger.info("------start to getNewIP() time is:"+DateUtil.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss"));
        String oldIP=getIP();
        if(StringUtil.isEmpty(oldIP)){
            return "";
        }
        change();
        String  newIP=getIP();
        while(StringUtil.isEmpty(newIP)||StringUtil.equals(oldIP, newIP)){
            logger.info("------newIP is empty !time is:"+DateUtil.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss"));
            try {
                //����������IP����ipһ�£�����change
                if(StringUtil.equals(oldIP, newIP)){
                    change();
                }
                Thread.currentThread().sleep(1*1000);
            } catch (InterruptedException ex) {
                logger.error("getNewIP() is error!",ex);
            }
            newIP=getIP();
        }
        return newIP;
    }
    
    /*
     * �ı�IP��ַ
     */
    public abstract void change();

    /**
     * ͨ������Զ�̷�������url������ȡ������IP
     * 
     * @return
     */
     protected String getIP() {
        try {
            URL url = new URL(getipUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setConnectTimeout(1000);
            connection.connect();
            // ȡ������������ʹ��Reader��ȡ
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"));// ���ñ���,������������
            String ip = "";
            String lines = "";
            while ((lines = reader.readLine()) != null) {
                ip += new String(lines.getBytes(), "utf-8");
            }
            reader.close();
            // �Ͽ�����
            connection.disconnect();
            logger.info("ChangeIPService.getIP(),IP=" + ip + ",----time:"
                        + DateUtil.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss"));
            return ip;
        } catch (Exception ex) {
            logger.error("ChangeIPService.getIP() is error��", ex);
        }
        return "";
    }

    // -------------------------------------ע��-------------------------------------------------------------------------------//

    public void setGetipUrl(String getipUrl) {
        this.getipUrl = getipUrl;
    }

}
