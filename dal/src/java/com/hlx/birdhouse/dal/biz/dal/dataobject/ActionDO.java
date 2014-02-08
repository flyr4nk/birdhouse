package com.hlx.birdhouse.dal.biz.dal.dataobject;

import java.io.Serializable;
import java.util.Date;

/**
 * 数据对象
 * @since 2013-09-02
 */
public class ActionDO implements Serializable {

    private static final long serialVersionUID = 137813124013322130L;

    /**
     * column action.id
     */
    private Integer id;

    /**
     * column action.wid
     */
    private Integer wid;

    /**
     * column action.event_name
     */
    private String eventName;

    /**
     * column action.x1
     */
    private Integer x1;

    /**
     * column action.y1
     */
    private Integer y1;

    /**
     * column action.x2
     */
    private Integer x2;

    /**
     * column action.y2
     */
    private Integer y2;

    /**
     * column action.strValue
     */
    private String strvalue;

    /**
     * column action.gmtCreate
     */
    private Date gmtcreate;

    /**
     * column action.gmtModified
     */
    private Date gmtmodified;
    
    private Integer waitTime;

    public ActionDO() {
        super();
    }

    public ActionDO(Integer id, Integer wid, String eventName, Integer x1, Integer y1, Integer x2, Integer y2, String strvalue, Date gmtcreate, Date gmtmodified,Integer waitTime) {
        this.id = id;
        this.wid = wid;
        this.eventName = eventName;
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.strvalue = strvalue;
        this.gmtcreate = gmtcreate;
        this.gmtmodified = gmtmodified;
        this.waitTime = waitTime;
    }

    /**
     * getter for Column action.id
     */
    public Integer getId() {
        return id;
    }

    /**
     * setter for Column action.id
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * getter for Column action.wid
     */
    public Integer getWid() {
        return wid;
    }

    /**
     * setter for Column action.wid
     * @param wid
     */
    public void setWid(Integer wid) {
        this.wid = wid;
    }

    /**
     * getter for Column action.event_name
     */
    public String getEventName() {
        return eventName;
    }

    /**
     * setter for Column action.event_name
     * @param eventName
     */
    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    /**
     * getter for Column action.x1
     */
    public Integer getX1() {
        return x1;
    }

    /**
     * setter for Column action.x1
     * @param x1
     */
    public void setX1(Integer x1) {
        this.x1 = x1;
    }

    /**
     * getter for Column action.y1
     */
    public Integer getY1() {
        return y1;
    }

    /**
     * setter for Column action.y1
     * @param y1
     */
    public void setY1(Integer y1) {
        this.y1 = y1;
    }

    /**
     * getter for Column action.x2
     */
    public Integer getX2() {
        return x2;
    }

    /**
     * setter for Column action.x2
     * @param x2
     */
    public void setX2(Integer x2) {
        this.x2 = x2;
    }

    /**
     * getter for Column action.y2
     */
    public Integer getY2() {
        return y2;
    }

    /**
     * setter for Column action.y2
     * @param y2
     */
    public void setY2(Integer y2) {
        this.y2 = y2;
    }

    /**
     * getter for Column action.strValue
     */
    public String getStrvalue() {
        return strvalue;
    }

    /**
     * setter for Column action.strValue
     * @param strvalue
     */
    public void setStrvalue(String strvalue) {
        this.strvalue = strvalue;
    }

    /**
     * getter for Column action.gmtCreate
     */
    public Date getGmtcreate() {
        return gmtcreate;
    }

    /**
     * setter for Column action.gmtCreate
     * @param gmtcreate
     */
    public void setGmtcreate(Date gmtcreate) {
        this.gmtcreate = gmtcreate;
    }

    /**
     * getter for Column action.gmtModified
     */
    public Date getGmtmodified() {
        return gmtmodified;
    }

    /**
     * setter for Column action.gmtModified
     * @param gmtmodified
     */
    public void setGmtmodified(Date gmtmodified) {
        this.gmtmodified = gmtmodified;
    }

	public Integer getWaitTime() {
		return waitTime;
	}

	public void setWaitTime(Integer waitTime) {
		this.waitTime = waitTime;
	}
    
    

}