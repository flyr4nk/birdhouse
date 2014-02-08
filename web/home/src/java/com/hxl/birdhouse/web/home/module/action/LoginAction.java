/*
 * Copyright 2012 zgnet.com All right reserved. This software is the
 * confidential and proprietary information of zgnet.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with zgnet.com.
 */
package com.hxl.birdhouse.web.home.module.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.citrus.turbine.Context;
import com.alibaba.citrus.turbine.Navigator;
import com.alibaba.citrus.turbine.Navigator.RedirectParameters;
import com.alibaba.citrus.turbine.TurbineRunData;
import com.alibaba.citrus.turbine.dataresolver.FormGroup;
import com.alibaba.citrus.util.StringUtil;
import com.alibaba.common.logging.Logger;
import com.alibaba.common.logging.LoggerFactory;
import com.hlx.birdhouse.common.constants.CookieConstants;
import com.hlx.birdhouse.common.constants.WebConstants;
import com.hlx.birdhouse.common.util.CookieUtil;

/**
 * 类LoginAction.java的实现描述：登录的action
 * 
 * @author maxjcs 2012-9-2 下午2:44:41
 */
public class LoginAction {

    private Logger              logger = LoggerFactory.getLogger(LoginAction.class);

    @Resource
    private HttpServletRequest  request;
    @Resource
    private HttpServletResponse response;

    public void doLogin(Navigator nav, Context context, TurbineRunData rundata) {
        boolean isSuccess = true;// loginService.login(accountDO);
        if (isSuccess) {
            // CookieUtil.setUserLoginCookie(request,response, accountDO.getEmail());
            // 返回到相关的页面
            String returnUrl = request.getParameter("returnUrl");
            if (!StringUtil.isBlank(returnUrl)) {
                nav.redirectToLocation(returnUrl);
            } else {
                nav.redirectTo(WebConstants.INDEX_LINK);
            }
        }

        return;
    }

    /**
     * 退出登录
     */
    public void doLogout(Navigator nav) {
        // String token = CookieUtil.getToken(request);
        CookieUtil.removeUserLoginCookie(request, response, CookieConstants.COOKIE_TOKEN);
        CookieUtil.removeUserLoginCookie(request, response, CookieConstants.COOKIE_LOGIN_ID);
        CookieUtil.removeUserLoginCookie(request, response, CookieConstants.DOMAIN_NAME);
        try {
            nav.redirectTo(WebConstants.USER_LOGIN_LINK);
        } catch (Exception e) {
            logger.error(e);
            RedirectParameters rp = nav.redirectTo(WebConstants.MESSAGE_LINK);
            rp.withParameter(WebConstants.MESSAGE_STATUS, WebConstants.ERROR_MESSAGE_CONTENT);
            return;
        }
    }

}
