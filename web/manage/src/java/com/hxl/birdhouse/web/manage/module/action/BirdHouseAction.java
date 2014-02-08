package com.hxl.birdhouse.web.manage.module.action;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.citrus.turbine.Context;
import com.alibaba.citrus.turbine.Navigator;
import com.alibaba.citrus.turbine.TurbineRunData;
import com.alibaba.common.lang.StringUtil;
import com.alibaba.common.logging.Logger;
import com.alibaba.common.logging.LoggerFactory;
import com.hlx.birdhouse.common.constants.BHConstants;
import com.hlx.birdhouse.common.service.BirdHouseService;
import com.hlx.birdhouse.common.util.MathUitl;
import com.hlx.birdhouse.common.vo.BirdHouseVO;
import com.hlx.birdhouse.dal.biz.dal.dataobject.ActionDO;
import com.hlx.birdhouse.dal.biz.dal.dataobject.ServerDO;
import com.hlx.birdhouse.dal.biz.dal.dataobject.WebsiteDO;

public class BirdHouseAction {

    private Logger              logger = LoggerFactory.getLogger(BirdHouseAction.class);

    @Resource
    private HttpServletRequest  request;
    @Resource
    private HttpServletResponse response;
    @Resource
    private BirdHouseService    birdHouseService;

    public void doAddOrUpdate(Navigator nav, Context context, TurbineRunData rundata) {
        // 获取网站信息
        String wid=request.getParameter("wid");
        String url = request.getParameter("url");
        String times = request.getParameter("times");
        String webWaitTime = request.getParameter("webWaitTime");
        WebsiteDO websiteDO = new WebsiteDO();
        websiteDO.setId(MathUitl.str2Int(wid));
        websiteDO.setUrl(url);
        websiteDO.setTimes(MathUitl.str2Int(times));
        websiteDO.setWaitTime(MathUitl.str2Int(webWaitTime));
        // 开始时间
        String year = request.getParameter("year");
        String month = request.getParameter("month");
        String dd = request.getParameter("dd");
        String hh = request.getParameter("hh");
        String mm = request.getParameter("mm");

        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, MathUitl.str2Int(year));
        cal.set(Calendar.MONTH, MathUitl.str2Int(month) - 1);
        cal.set(Calendar.DATE, MathUitl.str2Int(dd));
        cal.set(Calendar.HOUR_OF_DAY, MathUitl.str2Int(hh));
        cal.set(Calendar.MINUTE, MathUitl.str2Int(mm));
        cal.set(Calendar.SECOND,0);
        cal.set(Calendar.MILLISECOND, 0);
        websiteDO.setStartdate(cal.getTime());
        // 获取action信息
        String[] actionId = request.getParameterValues("actionId");
        String[] eventNames = request.getParameterValues("eventName");
        String[] x1s = request.getParameterValues("x1");
        String[] y1s = request.getParameterValues("y1");
        String[] x2s = request.getParameterValues("x2");
        String[] y2s = request.getParameterValues("y2");
        String[] waitTimes = request.getParameterValues("waitTime");
        List<ActionDO> actionList = new ArrayList<ActionDO>();
        for (int i = 0; i < eventNames.length; i++) {
            if (StringUtil.isEmpty(eventNames[i])) {
                continue;
            }
            ActionDO actionDO = new ActionDO();
            actionDO.setId(MathUitl.str2Int(actionId[i]));
            actionDO.setEventName(eventNames[i]);
            actionDO.setX1(MathUitl.str2Int(x1s[i]));
            actionDO.setY1(MathUitl.str2Int(y1s[i]));
            actionDO.setX2(MathUitl.str2Int(x2s[i]));
            actionDO.setY2(MathUitl.str2Int(y2s[i]));
            actionDO.setWaitTime(MathUitl.str2Int(waitTimes[i]));
            actionList.add(actionDO);
        }
        // 获取server信息
        String[] serverId = request.getParameterValues("serverId");
        String[] siteNames = request.getParameterValues("siteName");
        String[] nTimes = request.getParameterValues("nTimes");
        List<ServerDO> serverList = new ArrayList<ServerDO>();
        for (int i = 0; i < siteNames.length; i++) {
            if (StringUtil.isEmpty(siteNames[i])) {
                continue;
            }
            ServerDO serverDO = new ServerDO();
            serverDO.setId(MathUitl.str2Int(serverId[i]));
            serverDO.setSiteName(siteNames[i]);
            serverDO.setnTimes(MathUitl.str2Int(nTimes[i]));
            serverList.add(serverDO);
        }
        BirdHouseVO vo = new BirdHouseVO();
        vo.setActionList(actionList);
        vo.setWebsiteDO(websiteDO);
        vo.setServerDOList(serverList);

        //根据wid是否存在判断是insert还是update
        if(StringUtil.isEmpty(wid)){
            birdHouseService.insert(vo);
        }else{
            birdHouseService.update(vo);
        }
        context.put("isSuccess", Boolean.TRUE);

        return;
    }

    /**
     * 删除某个网站
     * 
     * @param nav
     * @param context
     * @param rundata
     */
    public void doDelete(Navigator nav, Context context, TurbineRunData rundata) {
        String wid = request.getParameter("wid");
        try {
            birdHouseService.delete(MathUitl.str2Int(wid));
            nav.redirectTo("manageUrl");
        } catch (Exception ex) {
            logger.error("BirdHouseAction.doDelete() wid=" + wid, ex);
        }
    }
    
    /**
     * 启动
     * @param nav
     * @param context
     * @param rundata
     */
    public void doStart(Navigator nav, Context context, TurbineRunData rundata){
        String wid = request.getParameter("wid");
        try {
            birdHouseService.startOrStop(MathUitl.str2Int(wid),BHConstants.SERVER_STATUS_RUNNING);
            nav.redirectTo("manageUrl");
        } catch (Exception ex) {
            logger.error("BirdHouseAction.doStartOrStop() wid=" + wid, ex);
        }
    }
    
    /**
     * 暂停
     * @param nav
     * @param context
     * @param rundata
     */
    public void doStop(Navigator nav, Context context, TurbineRunData rundata){
        String wid = request.getParameter("wid");
        try {
            birdHouseService.startOrStop(MathUitl.str2Int(wid),BHConstants.SERVER_STATUS_STOP);
            nav.redirectTo("manageUrl");
        } catch (Exception ex) {
            logger.error("BirdHouseAction.doStartOrStop() wid=" + wid, ex);
        }
    }

}
