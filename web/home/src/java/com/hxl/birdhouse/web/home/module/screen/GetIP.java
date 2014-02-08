/*
 * Copyright 2012 zgnet.com All right reserved. This software is the
 * confidential and proprietary information of zgnet.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with zgnet.com.
 */
package com.hxl.birdhouse.web.home.module.screen;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.citrus.turbine.Context;
import com.alibaba.citrus.turbine.Navigator;
import com.alibaba.common.logging.Logger;
import com.alibaba.common.logging.LoggerFactory;
import com.hlx.birdhouse.common.constants.WebConstants;

/**
 * 类Index.java的实现描述：首页
 * 
 * @author maxjcs 2012-10-2 下午4:08:46
 */
public class GetIP {

    private Logger             logger = LoggerFactory.getLogger(GetIP.class);

    @Resource
    private HttpServletRequest request;
    
    @Resource
    private HttpServletResponse response;

    public void execute(Navigator nav, Context context) {

        try {
            String host=request.getRemoteHost();
            System.out.print("host=="+host);
            response.getOutputStream().write(host.getBytes());
            response.flushBuffer();
        } catch (Exception ex) {
            logger.error("GetIP.execute() is error!", ex);
            nav.redirectTo(WebConstants.ERROR_LINK);
        }

    }

}
