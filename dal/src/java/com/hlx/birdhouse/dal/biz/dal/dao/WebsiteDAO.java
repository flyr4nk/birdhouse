package com.hlx.birdhouse.dal.biz.dal.dao;

import com.hlx.birdhouse.dal.biz.dal.dataobject.WebsiteDO;
import java.util.List;
import org.springframework.dao.DataAccessException;

/**
 * 数据访问对象接口
 * @since 2013-09-02
 */
public interface WebsiteDAO {

    /**
     * 插入数据
     * @param websiteDO
     * @return 插入数据的主键
     */
    public Integer insertWebsiteDO(WebsiteDO websiteDO) throws DataAccessException;

    /**
     * 统计记录数
     * @param websiteDO
     * @return 查出的记录数
     */
    public Integer countWebsiteDOByExample(WebsiteDO websiteDO) throws DataAccessException;

    /**
     * 更新记录
     * @param websiteDO
     * @return 受影响的行数
     */
    public Integer updateWebsiteDO(WebsiteDO websiteDO) throws DataAccessException;

    /**
     * 获取对象列表
     * @param websiteDO
     * @return 对象列表
     */
    public List<WebsiteDO> findListByExample(WebsiteDO websiteDO) throws DataAccessException;

    /**
     * 根据主键获取websiteDO
     * @param id
     * @return websiteDO
     */
    public WebsiteDO findWebsiteDOByPrimaryKey(Integer id) throws DataAccessException;

    /**
     * 删除记录
     * @param id
     * @return 受影响的行数
     */
    public Integer deleteWebsiteDOByPrimaryKey(Integer id) throws DataAccessException;
    
    /**
     * 翻页查询
     * @param pageNum
     * @return
     * @throws DataAccessException
     */
    public List<WebsiteDO> queryAll(Integer pageNum) throws DataAccessException;

}