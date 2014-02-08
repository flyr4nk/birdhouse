package com.hlx.birdhouse.common.service.mk;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.alibaba.common.lang.StringUtil;
import com.alibaba.common.logging.Logger;
import com.alibaba.common.logging.LoggerFactory;
import com.hlx.birdhouse.common.vo.BirdHouseVO;
import com.hlx.birdhouse.dal.biz.dal.dataobject.ActionDO;

/**
 * ��ActionService.java��ʵ��������
 * 
 * @author maxjcs 2013-9-11 ����3:02:01
 */
public class ActionService {

    private static final Logger logger  = LoggerFactory.getLogger(ActionService.class);

    private String              workDir = "d:/vbs/";

    public void runAction(String datafile) {
        Process process;
        try {
            // ���нű�
            process = Runtime.getRuntime().exec("wscript.exe " + workDir + "run.vbs  " + datafile);
            process.waitFor();
        } catch (Exception e) {
            logger.error("ActionService.runAction() is error!", e);
        }

    }

    /**
     * ��������Ƿ�ִ�гɹ����ļ������ok������data.vbs => data.vbs.ok
     * 
     * @param datafile
     * @return
     */
    public boolean checkSuccess(String datafile) {
        File file = new File(datafile + ".ok");
        if (file.exists()) {
            return true;
        }
        return false;
    }

    /**
     * ���������ļ�
     * 
     * @return
     */
    public List<String> createDataFile(BirdHouseVO vo) {
    	List<String> fileList=new ArrayList<String>();
        if (vo == null) {
            return fileList;
        }
        try {

            // �ж�Ŀ¼�Ƿ���ڣ������ڴ���
            File filedir = new File(workDir + vo.getWebsiteDO().getId());
            if (!filedir.exists()) {
                filedir.mkdir();
            }
            //��ȡurl,���url��http://www.**.com/detail.htm?id=[1-100]��ʽ��url��ʾΪһ��id��ͬurl��
            String url=vo.getWebsiteDO().getUrl();
            int sVal=-1;//��ʼֵ
            int eVal=-1;//����ֵ
            if(StringUtil.isNotBlank(url)&&url.contains("[")){
            	int beginIndex=url.indexOf("[");
            	int endIndex=url.indexOf("]");
            	String strsplit=url.substring(beginIndex+1, endIndex);
            	String[] strArry=strsplit.split("-");
            	
            	sVal=Integer.parseInt(strArry[0]);
            	eVal=Integer.parseInt(strArry[1]);
            }
            //�ж��ǲ��� ����url���ǣ�ѭ��
            if(sVal!=-1){
	            for(int i=sVal;i<eVal;i++){//�ļ�������idֵ
	            	String fileName=workDir + vo.getWebsiteDO().getId() + "/" + vo.getWebsiteDO().getId()+"_"+sVal + ".vbs";
	            	writeFile(vo,fileName);
	            	fileList.add(fileName);
	            }
            }else{
            	String fileName=workDir + vo.getWebsiteDO().getId() + "/" + vo.getWebsiteDO().getId() + ".vbs";
            	writeFile(vo,fileName);
            	fileList.add(fileName);
            }
        
        } catch (Exception ex) {
            logger.error("ActionService.createDataFile() is error!", ex);
        }
        return fileList;
    }
    
    public boolean writeFile(BirdHouseVO vo,String fileName){
    	try{
    	// ���������ļ�
        String datafileStr = workDir + vo.getWebsiteDO().getId() + "/" + vo.getWebsiteDO().getId() + ".vbs";
        // �ж��Ѿ�ִ�����ok�ļ�ʱ����ڣ�����ֱ��rename������createһ���µ��ļ�
        String datafileStr_ok = fileName + ".ok";
        File datafile_ok = new File(datafileStr_ok);
        File dataFile = new File(datafileStr);
        if (datafile_ok.exists()) {
            datafile_ok.renameTo(dataFile);
            return true;
        }
        //����һ���µ��ļ�
        FileWriter write = new FileWriter(dataFile);
        write.append("Dim url,eventStr  " + "\n");
        // д��url����
        write.append("url =  \"" + vo.getWebsiteDO().getUrl() + "\"    " + "\n");
        // д��waitTime����
        write.append("waitTime =  \"" + vo.getWebsiteDO().getWaitTime() + "\"    " + "\n");
        // д��action����,����eventStr = "click_51_606_1000|click_82_724_1000"
        StringBuffer actionStrBf = new StringBuffer();
        for (ActionDO actionDO : vo.getActionList()) {
            if (StringUtil.isBlank(actionDO.getEventName())) {
                continue;
            }
            actionStrBf.append(actionDO.getEventName());
            actionStrBf.append("_");
            actionStrBf.append(actionDO.getX1());
            actionStrBf.append("_");
            actionStrBf.append(actionDO.getY1());
            actionStrBf.append("_");
            actionStrBf.append(actionDO.getX2());
            actionStrBf.append("_");
            actionStrBf.append(actionDO.getY2());
            actionStrBf.append("_");
            actionStrBf.append(actionDO.getWaitTime());
            actionStrBf.append("|");
        }
        String actionStr = actionStrBf.toString();
        write.write("eventStr =\"" + actionStr.substring(0, actionStr.length() - 1) + "\"   \n");
        write.flush();
        write.close();
    	}catch(Exception ex){
    		logger.error("ActionService.writeFile() is error!", ex);
    		return false;
    	}
    	return true;
    }

    // --------------------------------ע��-----------------------------------------------//
    public void setWorkDir(String workDir) {
        this.workDir = workDir;
    }

}
