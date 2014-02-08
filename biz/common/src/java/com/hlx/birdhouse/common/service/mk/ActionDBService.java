package com.hlx.birdhouse.common.service.mk;

import java.util.List;

import javax.annotation.Resource;

import com.alibaba.common.lang.StringUtil;
import com.alibaba.common.logging.Logger;
import com.alibaba.common.logging.LoggerFactory;
import com.hlx.birdhouse.common.constants.BHConstants;
import com.hlx.birdhouse.common.service.BirdHouseService;
import com.hlx.birdhouse.common.vo.BirdHouseVO;
import com.hlx.birdhouse.dal.biz.dal.dao.ActionIpDAO;
import com.hlx.birdhouse.dal.biz.dal.dao.ServerDAO;
import com.hlx.birdhouse.dal.biz.dal.dataobject.ActionIpDO;
import com.hlx.birdhouse.dal.biz.dal.dataobject.ServerDO;

public class ActionDBService {

    private static final Logger logger   = LoggerFactory.getLogger(ActionDBService.class);

    @Resource
    private BirdHouseService    birdHouseService;

    private String              siteName = "hz";

    @Resource
    private ServerDAO           serverDAO;

    @Resource
    private ActionIpDAO         actionIpDAO;

    /**
     * ��ִ��״̬д�뵽db
     * 
     * @param vo
     */
    public boolean record(BirdHouseVO vo, String ip) {
        try {
            // ����action_ip��
            ActionIpDO actionIpDO = new ActionIpDO();
            actionIpDO.setWid(vo.websiteDO.getId());
            actionIpDO.setIp(ip);
            actionIpDAO.insertActionIpDO(actionIpDO);
            // ����server��,���ִ�д����ﵽ�ܴ�����״̬����Ϊ��ɡ�
            List<ServerDO> serverList = vo.getServerDOList();
            for (ServerDO serverDO : serverList) {
                if (StringUtil.equals(siteName, serverDO.getSiteName())) {
                    Integer nTimes = serverDO.getnTimes();
                    Integer dTimes = serverDO.getdTimes();
                    serverDO.setdTimes(dTimes + 1);
                    if (nTimes <= dTimes + 1) {
                        serverDO.setStatus(BHConstants.SERVER_STATUS_SUCCESS);
                    }
                    serverDAO.updateServerDO(serverDO);
                }
            }
            return true;
        } catch (Exception ex) {
            logger.error("ActionDBService.record() is error!", ex);
            return false;
        }
    }

    /**
     * ��ȡһ����������վ��������
     * 
     * @return
     */
    public BirdHouseVO getNextWebSite() {
        try{
        // ��ȡ��վ����һ����������վ����
        ServerDO queryDO = new ServerDO();
        queryDO.setSiteName(siteName);
        queryDO.setStatus(BHConstants.SERVER_STATUS_RUNNING);
        List<ServerDO> serverList = serverDAO.findListByExample(queryDO);
        // ȡ��һ����վ����
        ServerDO exeServerDO = null;
        ;
        if (serverList != null && serverList.size() > 0) {
            exeServerDO = serverList.get(0);
        }
        // ȡ��������������
        if (exeServerDO != null) {
            return birdHouseService.queryByWid(exeServerDO.getWid());
        }
        }catch(Exception ex){
            logger.error("Actionservirce.getNextWebSite() is error!", ex);
        }
        return null;
    }

    // -----------------------------------------------ע��----------------------------------------------------------//
    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

}
