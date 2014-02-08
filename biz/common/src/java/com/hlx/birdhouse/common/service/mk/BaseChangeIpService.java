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
     * 获取新的IP地址
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
                //如果更换后的IP跟旧ip一致，继续change
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
     * 改变IP地址
     */
    public abstract void change();

    /**
     * 通过请求远程服务器的url，来获取本机的IP
     * 
     * @return
     */
     protected String getIP() {
        try {
            URL url = new URL(getipUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setConnectTimeout(1000);
            connection.connect();
            // 取得输入流，并使用Reader读取
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"));// 设置编码,否则中文乱码
            String ip = "";
            String lines = "";
            while ((lines = reader.readLine()) != null) {
                ip += new String(lines.getBytes(), "utf-8");
            }
            reader.close();
            // 断开连接
            connection.disconnect();
            logger.info("ChangeIPService.getIP(),IP=" + ip + ",----time:"
                        + DateUtil.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss"));
            return ip;
        } catch (Exception ex) {
            logger.error("ChangeIPService.getIP() is error！", ex);
        }
        return "";
    }

    // -------------------------------------注入-------------------------------------------------------------------------------//

    public void setGetipUrl(String getipUrl) {
        this.getipUrl = getipUrl;
    }

}
