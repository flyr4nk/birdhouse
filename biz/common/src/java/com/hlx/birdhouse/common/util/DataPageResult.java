/*
 * Copyright 2013 zgnet.com All right reserved. This software is the
 * confidential and proprietary information of zgnet.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with zgnet.com.
 */
package com.hlx.birdhouse.common.util;

import java.util.List;

/**
 * 类DataPageResult.java的实现描述：TODO 类实现描述 
 * @author maxjcs 2013-1-8 上午11:32:56
 */
public class DataPageResult {
    
    //起始页
    private int beginPage = 0;
    //每页显示的记录条数
    private int pageSize = 10;//默认每页显示10条数据
    //上一页
    private int previousPage = 0;
    //下一页
    private int nextPage = 0;
    //总页数
    private int totalPage = 0;
    //总记录数
    private int totalNumber = 0;
    //分页查询结果
    private List result = null;
    
    public DataPageResult(){
        this.beginPage = 1;
        this.beginPage = 10;
    }
    
    public DataPageResult(List result,int totalNumber){
        this.result = result;
        this.totalNumber = totalNumber;
    }

    public int getBeginPage() {
        return beginPage;
    }

    public void setBeginPage(int beginPage) {
        this.beginPage = beginPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getTotalNumber() {
        return totalNumber;
    }

    public void setTotalNumber(int totalNumber) {
        this.totalNumber = totalNumber;
    }

    public List getResult() {
        return result;
    }

    public void setResult(List result) {
        this.result = result;
    }

    public int getPreviousPage(){
        if(previousPage<=0){
            return previousPage;
        } else {
            return previousPage-1;
        }
    }

    public void setPreviousPage(int previousPage) {
        this.previousPage = previousPage;
    }

    public int getNextPage() {
        if(nextPage>=this.totalPage){
            return this.totalPage;
        }else{
            return nextPage++;
        }
    }

    public void setNextPage(int nextPage) {
        this.nextPage = nextPage;
    }

}
