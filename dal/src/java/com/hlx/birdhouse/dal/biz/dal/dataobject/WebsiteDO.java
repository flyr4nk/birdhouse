package com.hlx.birdhouse.dal.biz.dal.dataobject;

import java.io.Serializable;
import java.util.Date;

/**
 * 数据对象
 * @since 2013-09-02
 */
public class WebsiteDO implements Serializable {

    private static final long serialVersionUID = 137813138726361616L;

    /**
     * column website.id
     */
    private Integer id;

    /**
     * column website.url
     */
    private String url;

    /**
     * column website.times
     */
    private Integer times;

    /**
     * column website.startDate
     */
    private Date startdate;

    /**
     * column website.gmtCreate
     */
    private Date gmtcreate;

    /**
     * column website.gmtModified
     */
    private Date gmtmodified;

    /**
     * column website.name
     */
    private String name;

    /**
     * column website.pwd
     */
    private String pwd;

    /**
     * column website.strValue
     */
    private String strvalue;

    /**
     * column website.strValue2
     */
    private String strvalue2;
    
    /**
     * 等待时间
     */
    private Integer waitTime;

    public WebsiteDO() {
        super();
    }

    public WebsiteDO(Integer id, String url, Integer times, Date startdate, Date gmtcreate, Date gmtmodified, String name, String pwd, String strvalue, String strvalue2,Integer waitTime) {
        this.id = id;
        this.url = url;
        this.times = times;
        this.startdate = startdate;
        this.gmtcreate = gmtcreate;
        this.gmtmodified = gmtmodified;
        this.name = name;
        this.pwd = pwd;
        this.strvalue = strvalue;
        this.strvalue2 = strvalue2;
        this.waitTime=waitTime;
    }

    /**
     * getter for Column website.id
     */
    public Integer getId() {
        return id;
    }

    /**
     * setter for Column website.id
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * getter for Column website.url
     */
    public String getUrl() {
        return url;
    }

    /**
     * setter for Column website.url
     * @param url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * getter for Column website.times
     */
    public Integer getTimes() {
        return times;
    }

    /**
     * setter for Column website.times
     * @param times
     */
    public void setTimes(Integer times) {
        this.times = times;
    }

    /**
     * getter for Column website.startDate
     */
    public Date getStartdate() {
        return startdate;
    }

    /**
     * setter for Column website.startDate
     * @param startdate
     */
    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    /**
     * getter for Column website.gmtCreate
     */
    public Date getGmtcreate() {
        return gmtcreate;
    }

    /**
     * setter for Column website.gmtCreate
     * @param gmtcreate
     */
    public void setGmtcreate(Date gmtcreate) {
        this.gmtcreate = gmtcreate;
    }

    /**
     * getter for Column website.gmtModified
     */
    public Date getGmtmodified() {
        return gmtmodified;
    }

    /**
     * setter for Column website.gmtModified
     * @param gmtmodified
     */
    public void setGmtmodified(Date gmtmodified) {
        this.gmtmodified = gmtmodified;
    }

    /**
     * getter for Column website.name
     */
    public String getName() {
        return name;
    }

    /**
     * setter for Column website.name
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * getter for Column website.pwd
     */
    public String getPwd() {
        return pwd;
    }

    /**
     * setter for Column website.pwd
     * @param pwd
     */
    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    /**
     * getter for Column website.strValue
     */
    public String getStrvalue() {
        return strvalue;
    }

    /**
     * setter for Column website.strValue
     * @param strvalue
     */
    public void setStrvalue(String strvalue) {
        this.strvalue = strvalue;
    }

    /**
     * getter for Column website.strValue2
     */
    public String getStrvalue2() {
        return strvalue2;
    }

    /**
     * setter for Column website.strValue2
     * @param strvalue2
     */
    public void setStrvalue2(String strvalue2) {
        this.strvalue2 = strvalue2;
    }

	public Integer getWaitTime() {
		return waitTime;
	}

	public void setWaitTime(Integer waitTime) {
		this.waitTime = waitTime;
	}
    
    

}