/*
 * Copyright 2013 zgnet.com All right reserved. This software is the
 * confidential and proprietary information of zgnet.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with zgnet.com.
 */
package com.hlx.birdhouse.common.constants;

/**
 * 类Constants.java的实现描述：TODO 类实现描述
 * 
 * @author maxjcs 2013-1-8 上午11:36:06
 */
public class Constants {
    
    public static int PAGE_SIZE=20;  

    public static String TRS_SERVER_IP   = "127.0.0.1";
    public static String TRS_SERVER_PORT = "8888";
    public static String TRS_USER_NAME   = "system";
    public static String TRS_PASSWORD    = "manager";
    public static String TRS_DBANME      = "SYSTEM.DA_ABC";
    public static String TRS_DB_OWNER    = "system";
    
    public static String LOGIN_USER_NAME    = "zjpost";
    public static String LOGIN_PASSWORD    = "234567"; 
    
    //档案查询搜索字段
    public static final String Fields_WS[] = { "bt", "wh", "doc", "cbdw", "dh", "hh", "jh", "nd", "ngr", "wdysname", "wh", "zsdw", "ztc", "zrz" };
    //档案查询展示字段
    public static final String SHOWS_WS[] = { "bt", "wh", "dh", "nd", "zrz", "lj", "id" };

}
