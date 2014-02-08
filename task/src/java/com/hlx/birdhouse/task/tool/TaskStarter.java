package com.hlx.birdhouse.task.tool;

import com.alibaba.common.logging.Logger;
import com.alibaba.common.logging.LoggerFactory;
import com.hlx.birdhouse.common.service.mk.MKService;
import com.hlx.birdhouse.task.WebxEnvMain;

/**
 * 用户关注指标监控类.
 * @author dachun.daidc
 *
 */
public class TaskStarter extends WebxEnvMain {
	
	private static final Logger logger = LoggerFactory.getLogger(TaskStarter.class);
	
	public static void main(String[] args) {
		TaskStarter starter = new TaskStarter();
		MKService mkService = (MKService) starter.getBean("mkService");
		mkService.start();
		logger.error("-------------mkService task started:---------------- " );
	}
}
