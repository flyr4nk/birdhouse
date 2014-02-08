package com.hlx.birdhouse.dal.biz.dal.dataobject;

import java.io.Serializable;
import java.util.Date;

/**
 * 数据对象
 * @since 2013-09-03
 */
public class ServerDO implements Serializable {

    private static final long serialVersionUID = 137821517069633202L;

    /**
     * column server.id
     */
    private Integer id;

    /**
     * column server.site_name  站点名，比如hz，sh
     */
    private String siteName;

    /**
     * column server.wid  网站id
     */
    private Integer wid;

    /**
     * column server.n_times  需要执行的次数
     */
    private Integer nTimes;

    /**
     * column server.d_times  已经完成的次数
     */
    private Integer dTimes;

    /**
     * column server.status  状态
     */
    private String status;

    /**
     * column server.gmtCreate  创建时间
     */
    private Date gmtcreate;

    /**
     * column server.gmtModified  修改时间
     */
    private Date gmtmodified;

    public ServerDO() {
        super();
    }

    public ServerDO(Integer id, String siteName, Integer wid, Integer nTimes, Integer dTimes, String status, Date gmtcreate, Date gmtmodified) {
        this.id = id;
        this.siteName = siteName;
        this.wid = wid;
        this.nTimes = nTimes;
        this.dTimes = dTimes;
        this.status = status;
        this.gmtcreate = gmtcreate;
        this.gmtmodified = gmtmodified;
    }

    /**
     * getter for Column server.id
     */
    public Integer getId() {
        return id;
    }

    /**
     * setter for Column server.id
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * getter for Column server.site_name
     */
    public String getSiteName() {
        return siteName;
    }

    /**
     * setter for Column server.site_name
     * @param siteName
     */
    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    /**
     * getter for Column server.wid
     */
    public Integer getWid() {
        return wid;
    }

    /**
     * setter for Column server.wid
     * @param wid
     */
    public void setWid(Integer wid) {
        this.wid = wid;
    }

    /**
     * getter for Column server.n_times
     */
    public Integer getnTimes() {
        return nTimes;
    }

    /**
     * setter for Column server.n_times
     * @param nTimes
     */
    public void setnTimes(Integer nTimes) {
        this.nTimes = nTimes;
    }

    /**
     * getter for Column server.d_times
     */
    public Integer getdTimes() {
        return dTimes;
    }

    /**
     * setter for Column server.d_times
     * @param dTimes
     */
    public void setdTimes(Integer dTimes) {
        this.dTimes = dTimes;
    }

    /**
     * getter for Column server.status
     */
    public String getStatus() {
        return status;
    }

    /**
     * setter for Column server.status
     * @param status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * getter for Column server.gmtCreate
     */
    public Date getGmtcreate() {
        return gmtcreate;
    }

    /**
     * setter for Column server.gmtCreate
     * @param gmtcreate
     */
    public void setGmtcreate(Date gmtcreate) {
        this.gmtcreate = gmtcreate;
    }

    /**
     * getter for Column server.gmtModified
     */
    public Date getGmtmodified() {
        return gmtmodified;
    }

    /**
     * setter for Column server.gmtModified
     * @param gmtmodified
     */
    public void setGmtmodified(Date gmtmodified) {
        this.gmtmodified = gmtmodified;
    }

}