package com.hlx.birdhouse.common.vo;

import java.util.List;

import com.hlx.birdhouse.dal.biz.dal.dataobject.ActionDO;
import com.hlx.birdhouse.dal.biz.dal.dataobject.ServerDO;
import com.hlx.birdhouse.dal.biz.dal.dataobject.WebsiteDO;

public class BirdHouseVO {
    
    public WebsiteDO websiteDO;
    public List<ActionDO> actionList;
    public List<ServerDO> serverDOList;
    
    public WebsiteDO getWebsiteDO() {
        return websiteDO;
    }
    
    public void setWebsiteDO(WebsiteDO websiteDO) {
        this.websiteDO = websiteDO;
    }
    
    public List<ActionDO> getActionList() {
        return actionList;
    }
    
    public void setActionList(List<ActionDO> actionList) {
        this.actionList = actionList;
    }

    
    public List<ServerDO> getServerDOList() {
        return serverDOList;
    }

    
    public void setServerDOList(List<ServerDO> serverDOList) {
        this.serverDOList = serverDOList;
    }
    
    
    
    
    
}
