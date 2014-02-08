/*
 * Copyright 2013 zgnet.com All right reserved. This software is the
 * confidential and proprietary information of zgnet.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with zgnet.com.
 */
package com.hlx.birdhouse.common.vo;

import com.hlx.birdhouse.dal.biz.dal.dataobject.WebsiteDO;


/**
 * 类WebSiteVO.java的实现描述：TODO 类实现描述 
 * @author maxjcs 2013-9-10 下午2:11:16
 */
public class WebsiteVO extends WebsiteDO {
    /**
     * 
     */
    private static final long serialVersionUID = 6492655535768145523L;
    public String serverState;

    
    public String getServerState() {
        return serverState;
    }

    
    public void setServerState(String serverState) {
        this.serverState = serverState;
    }
    
    
}
