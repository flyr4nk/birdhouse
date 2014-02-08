package com.hlx.birdhouse.dal.biz.dal.dataobject;

import java.io.Serializable;
import java.util.Date;

/**
 * 数据对象
 * @since 2013-09-02
 */
public class ActionIpDO implements Serializable {

    private static final long serialVersionUID = 137813135801400947L;

    /**
     * column action_ip.id
     */
    private Integer id;

    /**
     * column action_ip.wid
     */
    private Integer wid;

    /**
     * column action_ip.ip
     */
    private String ip;

    /**
     * column action_ip.gmtCreate
     */
    private Date gmtcreate;

    /**
     * column action_ip.gmtModified
     */
    private Date gmtmodified;

    public ActionIpDO() {
        super();
    }

    public ActionIpDO(Integer id, Integer wid, String ip, Date gmtcreate, Date gmtmodified) {
        this.id = id;
        this.wid = wid;
        this.ip = ip;
        this.gmtcreate = gmtcreate;
        this.gmtmodified = gmtmodified;
    }

    /**
     * getter for Column action_ip.id
     */
    public Integer getId() {
        return id;
    }

    /**
     * setter for Column action_ip.id
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * getter for Column action_ip.wid
     */
    public Integer getWid() {
        return wid;
    }

    /**
     * setter for Column action_ip.wid
     * @param wid
     */
    public void setWid(Integer wid) {
        this.wid = wid;
    }

    /**
     * getter for Column action_ip.ip
     */
    public String getIp() {
        return ip;
    }

    /**
     * setter for Column action_ip.ip
     * @param ip
     */
    public void setIp(String ip) {
        this.ip = ip;
    }

    /**
     * getter for Column action_ip.gmtCreate
     */
    public Date getGmtcreate() {
        return gmtcreate;
    }

    /**
     * setter for Column action_ip.gmtCreate
     * @param gmtcreate
     */
    public void setGmtcreate(Date gmtcreate) {
        this.gmtcreate = gmtcreate;
    }

    /**
     * getter for Column action_ip.gmtModified
     */
    public Date getGmtmodified() {
        return gmtmodified;
    }

    /**
     * setter for Column action_ip.gmtModified
     * @param gmtmodified
     */
    public void setGmtmodified(Date gmtmodified) {
        this.gmtmodified = gmtmodified;
    }

}