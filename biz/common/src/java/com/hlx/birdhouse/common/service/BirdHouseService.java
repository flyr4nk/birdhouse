package com.hlx.birdhouse.common.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.alibaba.common.lang.Paginator;
import com.alibaba.common.logging.Logger;
import com.alibaba.common.logging.LoggerFactory;
import com.hlx.birdhouse.common.constants.BHConstants;
import com.hlx.birdhouse.common.constants.Constants;
import com.hlx.birdhouse.common.util.PageList;
import com.hlx.birdhouse.common.util.StringUtils;
import com.hlx.birdhouse.common.vo.BirdHouseVO;
import com.hlx.birdhouse.dal.biz.dal.dao.ActionDAO;
import com.hlx.birdhouse.dal.biz.dal.dao.ActionIpDAO;
import com.hlx.birdhouse.dal.biz.dal.dao.ServerDAO;
import com.hlx.birdhouse.dal.biz.dal.dao.WebsiteDAO;
import com.hlx.birdhouse.dal.biz.dal.dataobject.ActionDO;
import com.hlx.birdhouse.dal.biz.dal.dataobject.ServerDO;
import com.hlx.birdhouse.dal.biz.dal.dataobject.WebsiteDO;

/**
 * ��BirdHouseService.java��ʵ��������¼����վ��������Ϣservice
 * 
 * @author maxjcs 2013-9-3 ����2:30:35
 */
public class BirdHouseService {

    private static final Logger logger = LoggerFactory.getLogger(BirdHouseService.class);
    @Resource
    private ActionDAO           actionDAO;
    @Resource
    private ActionIpDAO         actionIpDAO;
    @Resource
    private ServerDAO           serverDAO;
    @Resource
    private WebsiteDAO          websiteDAO;

    public void insert(BirdHouseVO bhVO) {
        try {
            WebsiteDO websiteDO = bhVO.getWebsiteDO();
            // ����website����������
            Integer wid = websiteDAO.insertWebsiteDO(websiteDO);
            List<ActionDO> actionList = bhVO.getActionList();
            // Ϊÿ��action����wid,Ȼ�����action��
            for (ActionDO actionDO : actionList) {
                actionDO.setWid(wid);
                actionDAO.insertActionDO(actionDO);
            }
            // ����վ��server��
            List<ServerDO> serverDOList = bhVO.getServerDOList();
            for (ServerDO serverDO : serverDOList) {
                serverDO.setWid(wid);
                serverDO.setdTimes(0);
                serverDO.setStatus(BHConstants.SERVER_STATUS_UNSTART);
                serverDAO.insertServerDO(serverDO);
            }
        } catch (Exception ex) {
            logger.error("BirdHouseService.insert()", ex);
        }

    }

    public void update(BirdHouseVO bhVO) {
        try {
            WebsiteDO websiteDO = bhVO.getWebsiteDO();
            // ����website����������
            websiteDAO.updateWebsiteDO(websiteDO);
            List<ActionDO> actionList = bhVO.getActionList();
            // Ϊÿ��action����wid,Ȼ�����action��
            for (ActionDO actionDO : actionList) {
                actionDO.setWid(websiteDO.getId());
                if(actionDO.getId()>0){
                    actionDAO.updateActionDO(actionDO);
                }else{
                    actionDAO.insertActionDO(actionDO);
                }
                
            }
            // ����վ��server��
            List<ServerDO> serverDOList = bhVO.getServerDOList();
            for (ServerDO serverDO : serverDOList) {
                serverDO.setWid(websiteDO.getId());
                serverDO.setStatus(BHConstants.SERVER_STATUS_UNSTART);
                if(serverDO.getId()>0){
                    serverDAO.updateServerDO(serverDO);
                }else{
                    serverDAO.insertServerDO(serverDO);
                }
            }
        } catch (Exception ex) {
            logger.error("BirdHouseService.update()", ex);
        }
    }

    public void delete(Integer wid) {
        try {
            actionDAO.deleteByWid(wid);
            serverDAO.deleteByWid(wid);
            websiteDAO.deleteWebsiteDOByPrimaryKey(wid);
        } catch (Exception ex) {
            logger.error("BirdHouseService.delete()", ex);
        }
    }

    public BirdHouseVO queryByWid(Integer wid) {
        BirdHouseVO vo = new BirdHouseVO();
        WebsiteDO websiteDO = websiteDAO.findWebsiteDOByPrimaryKey(wid);
        vo.setWebsiteDO(websiteDO);

        // ��ѯ���еĲ���
        ActionDO queryActionDO = new ActionDO();
        queryActionDO.setWid(wid);
        List<ActionDO> actionList = actionDAO.findListByExample(queryActionDO);
        //Ϊ�˲���4��DO��Ϊ��ǰ̨չʾ��ȷ���õط��Ժ��޸�
        int actionSize=actionList.size();
        for(int i=4;i>actionSize;i--){
            actionList.add(new ActionDO());
        }
        vo.setActionList(actionList);

        // ��ѯ���еķ�����
        ServerDO queryServerDO = new ServerDO();
        queryServerDO.setWid(wid);
        List<ServerDO> serverList = serverDAO.findListByExample(queryServerDO);
        //Ϊ�˲���2��DO��Ϊ��ǰ̨չʾ��ȷ���õط��Ժ��޸�
        int serverSize=serverList.size();
        for(int i=2;i>serverSize;i--){
            serverList.add(new ServerDO());
        }
        vo.setServerDOList(serverList);

        return vo;
    }

    @SuppressWarnings("unchecked")
    public Map getWebsiteList(Integer pageNum) {
        Map retMap=new HashMap();
        PageList pageList = new PageList();
        Integer count = websiteDAO.countWebsiteDOByExample(null);
        List<WebsiteDO> websiteList=websiteDAO.queryAll(pageNum);
        
        Map serverMap=new HashMap();
        for(WebsiteDO websiteDO:websiteList){
            ServerDO queryDO=new ServerDO();
            queryDO.setWid(websiteDO.getId());
            List<ServerDO> serverDOList=serverDAO.findListByExample(queryDO);
            StringBuffer retStrB=new StringBuffer();
            for(ServerDO serverDO:serverDOList){
                retStrB.append(serverDO.getSiteName());
                retStrB.append("_");
                retStrB.append((serverDO.getdTimes()==null?"0":serverDO.getdTimes())+"/"+serverDO.getnTimes());
                if(StringUtils.isEqualsIgnoreCase(serverDO.getStatus(), BHConstants.SERVER_STATUS_UNSTART)){
                    retStrB.append("_δ��ʼ");
                }else if(StringUtils.isEqualsIgnoreCase(serverDO.getStatus(), BHConstants.SERVER_STATUS_STOP)){
                    retStrB.append("_��ͣ");
                }else if(StringUtils.isEqualsIgnoreCase(serverDO.getStatus(), BHConstants.SERVER_STATUS_RUNNING)){
                    retStrB.append("_������");
                }else{
                    retStrB.append("_�����");
                }
                    
                retStrB.append("||");
                serverMap.put(websiteDO.getId(), retStrB.toString());
            }
        }
        Paginator paginator = new Paginator();
        paginator.setPage(pageNum == null ? 1 : pageNum);
        paginator.setItemsPerPage(Constants.PAGE_SIZE);
        pageList.setPaginator(paginator);
        paginator.setItems(count);
        pageList.addAll(websiteList);
        
        retMap.put("pageList", pageList);
        retMap.put("serverMap", serverMap);

        return retMap;

    }
    
    public Integer startOrStop(Integer wid,String status){
        ServerDO updateDO=new ServerDO();
        updateDO.setWid(wid);
        updateDO.setStatus(status);
        return serverDAO.updateServerStatus(updateDO);
    }

}
