package com.hxl.birdhouse.web.home.module.screen;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.citrus.turbine.Context;
import com.alibaba.citrus.turbine.Navigator;
import com.alibaba.common.logging.Logger;
import com.alibaba.common.logging.LoggerFactory;
import com.hlx.birdhouse.common.constants.WebConstants;
import com.hlx.birdhouse.common.service.mk.ChangeIpService4Adsl;
import com.hlx.birdhouse.dal.biz.dal.dao.ActionIpDAO;
import com.hlx.birdhouse.dal.biz.dal.dataobject.ActionIpDO;

public class TestIP {

    private Logger               logger = LoggerFactory.getLogger(TestIP.class);

    @Resource
    private HttpServletRequest   request;

    @Resource
    private HttpServletResponse  response;

    @Resource
    private ChangeIpService4Adsl changeIpService4Adsl;

    @Resource
    private ActionIpDAO          actionIpDAO;

    public void execute(Navigator nav, Context context) {

        try {
            logger.error("------------------start to fetchIp----------------------------------------");
            while (true) {
                String ip = changeIpService4Adsl.getNewIP();
                // 判断该IP是否已经获取过
                ActionIpDO queryDO = new ActionIpDO();
                queryDO.setIp(ip);
                List<ActionIpDO> list = actionIpDAO.findListByExample(queryDO);

                if (list != null && list.size() == 0) {
                    ActionIpDO insertDO = new ActionIpDO();
                    insertDO.setIp(ip);
                    insertDO.setWid(1);
                    actionIpDAO.insertActionIpDO(insertDO);
                }
            }
        } catch (Exception ex) {
            logger.error("GetIP.execute() is error!", ex);
            nav.redirectTo(WebConstants.ERROR_LINK);
        }

    }

}
