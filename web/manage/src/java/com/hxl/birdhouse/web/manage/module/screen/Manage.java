package com.hxl.birdhouse.web.manage.module.screen;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.alibaba.citrus.turbine.Context;
import com.alibaba.citrus.turbine.Navigator;
import com.alibaba.common.logging.Logger;
import com.alibaba.common.logging.LoggerFactory;
import com.hlx.birdhouse.common.constants.WebConstants;
import com.hlx.birdhouse.common.service.BirdHouseService;
import com.hlx.birdhouse.common.util.MathUitl;

public class Manage {
    
    private Logger             logger = LoggerFactory.getLogger(Manage.class);

    @Resource
    private HttpServletRequest request;
    @Resource
    private BirdHouseService    birdHouseService;

    @SuppressWarnings("rawtypes")
    public void execute(Navigator nav, Context context) {

        try {
            String pageNum=request.getParameter("pageNum");
            Map  retMap = birdHouseService.getWebsiteList(MathUitl.str2Int(pageNum));
            context.put("pageList", retMap.get("pageList"));
            context.put("serverMap", retMap.get("serverMap"));
        } catch (Exception ex) {
            logger.error("Manage.execute() is error!", ex);
            nav.redirectTo(WebConstants.ERROR_LINK);
        }

    }

}
