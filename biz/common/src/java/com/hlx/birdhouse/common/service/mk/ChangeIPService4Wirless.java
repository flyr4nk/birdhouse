package com.hlx.birdhouse.common.service.mk;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;

import org.apache.commons.httpclient.util.DateUtil;

import com.alibaba.common.logging.Logger;
import com.alibaba.common.logging.LoggerFactory;

/**
 * 
 * 类ChangeIPService.java的实现描述：更换IP的service 
 * @author maxjcs 2013-9-11 下午3:01:32
 */
public class ChangeIPService4Wirless extends BaseChangeIpService {
    
    private static final Logger logger = LoggerFactory.getLogger(ChangeIPService4Wirless.class);

    private  String changeipUrl        = "http://192.168.1.1/userRpm/SysRebootRpm.htm?Reboot=%D6%D8%C6%F4%C2%B7%D3%C9%C6%F7";

    private String changeipCode="Basic YWRtaW46SmlhbmdjaHNoNjIw";
    


    /**
     * 更换IP
     */
    public  void change() {
        try {
            logger.info("start to change() time is :"+DateUtil.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss"));
            URL url = new URL(changeipUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestProperty("Authorization", changeipCode);
            connection.connect();
            // 取得输入流，并使用Reader读取
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"));// 设置编码,否则中文乱码
            String lines;
            while ((lines = reader.readLine()) != null) {
                lines = new String(lines.getBytes(), "utf-8");
            }
            reader.close();
            // 断开连接
            connection.disconnect();
        } catch (Exception e) {
            logger.error("ChangeIPService.change() is error！", e);
        }
    }
       
    
    //-------------------------------------注入-------------------------------------------------------------------------------//
    public void setChangeipUrl(String changeipUrl) {
        this.changeipUrl = changeipUrl;
    }
    
    public void setChangeipCode(String changeipCode) {
        this.changeipCode = changeipCode;
    }   
    

    /**
     * @param args
     */
    public static void main(String[] args) {
        // 打印改变前的IP
        ChangeIPService4Wirless service =new ChangeIPService4Wirless();
        System.out.println(service.getIP());

        // change();
        //
        // //打印改变后的Ip
        // printIP();

    }

    


}
