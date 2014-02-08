package com.hxl.birdhouse.web.manage.module.screen;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.alibaba.citrus.turbine.Context;
import com.alibaba.citrus.turbine.Navigator;
import com.alibaba.common.lang.MathUtil;
import com.alibaba.common.logging.Logger;
import com.alibaba.common.logging.LoggerFactory;
import com.hlx.birdhouse.common.constants.WebConstants;
import com.hlx.birdhouse.common.service.BirdHouseService;
import com.hlx.birdhouse.common.util.MathUitl;
import com.hlx.birdhouse.common.vo.BirdHouseVO;

public class AddOrUpdate {
    private Logger             logger = LoggerFactory.getLogger(AddOrUpdate.class);

    @Resource
    private HttpServletRequest request;
    @Resource
    private BirdHouseService    birdHouseService;

    public void execute(Navigator nav, Context context) {

        try {
            String wid=request.getParameter("wid");
            BirdHouseVO vo = birdHouseService.queryByWid(MathUitl.str2Int(wid));
            context.put("vo", vo);
        } catch (Exception ex) {
            logger.error("AddOrUpdate.execute() is error!", ex);
            nav.redirectTo(WebConstants.ERROR_LINK);
        }

    }
}
