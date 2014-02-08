package com.hlx.birdhouse.common.service.mk;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import com.alibaba.common.logging.Logger;
import com.alibaba.common.logging.LoggerFactory;

public class ChangeIpService4Adsl extends BaseChangeIpService {

    private static final Logger logger = LoggerFactory.getLogger(ChangeIpService4Adsl.class);
    
    private String adslTitle="Vnet_PPPoE";
    
    private String adslName="18005887984";
    
    private String adslPassword="123789";

    /**
     * 更换IP
     */
    public void change() {
        try {
            cutAdsl(adslTitle);
            Thread.sleep(1000);
            // 再连，分配一个新的IP
            connAdsl(adslTitle, adslName,adslPassword);
        } catch (Exception ex) {
            logger.error("ChaneIpService4Adsl.change() is error!", ex);
        }
    }

    /**
     * 执行CMD命令,并返回String字符串
     */
    public static String executeCmd(String strCmd) throws Exception {
        Process p = Runtime.getRuntime().exec("cmd /c " + strCmd);
        StringBuilder sbCmd = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
        String line;
        while ((line = br.readLine()) != null) {
            sbCmd.append(line + "\n");
        }
        return sbCmd.toString();
    }

    /**
     * 连接ADSL
     */
    public static boolean connAdsl(String adslTitle, String adslName, String adslPass) throws Exception {
        System.out.println("正在建立连接.");
        String adslCmd = "rasdial " + adslTitle + " " + adslName + " " + adslPass;
        String tempCmd = executeCmd(adslCmd);
        // 判断是否连接成功
        if (tempCmd.indexOf("已连接") > 0) {
            System.out.println("已成功建立连接.");
            return true;
        } else {
            System.err.println(tempCmd);
            System.err.println("建立连接失败");
            return false;
        }
    }

    /**
     * 断开ADSL
     */
    public static boolean cutAdsl(String adslTitle) throws Exception {
        String cutAdsl = "rasdial " + adslTitle + " /disconnect";
        String result = executeCmd(cutAdsl);

        if (result.indexOf("没有连接") != -1) {
            System.err.println(adslTitle + "连接不存在!");
            return false;
        } else {
            System.out.println("连接已断开");
            return true;
        }
    }
    
    //-------------------------------------------注入--------------------------------------------//
    
    public void setAdslTitle(String adslTitle) {
        this.adslTitle = adslTitle;
    }

    
    public void setAdslName(String adslName) {
        this.adslName = adslName;
    }

    
    public void setAdslPassword(String adslPassword) {
        this.adslPassword = adslPassword;
    }
    

    public static void main(String[] args) throws Exception {
        // connAdsl("Vnet_PPPoE","18005887984","123789");
        Thread.sleep(1000);
        cutAdsl("Vnet_PPPoE");
        Thread.sleep(1000);
        // 再连，分配一个新的IP
        connAdsl("Vnet_PPPoE", "18005887984", "123789");
    }

    

}
