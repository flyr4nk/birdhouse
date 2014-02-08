package com.hlx.birdhouse.dal.biz.dal.dao.impl;

import com.hlx.birdhouse.dal.biz.dal.dao.WebsiteDAO;
import com.hlx.birdhouse.dal.biz.dal.dataobject.WebsiteDO;
import java.util.List;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

/**
 * 数据访问对象实现类
 * @since 2013-09-02
 */
public class WebsiteDAOImpl extends SqlMapClientDaoSupport implements WebsiteDAO {

    /**
     * 插入数据
     * @param websiteDO
     * @return 插入数据的主键
     */
    public Integer insertWebsiteDO(WebsiteDO websiteDO) throws DataAccessException {
        Object id = getSqlMapClientTemplate().insert("Website.insert", websiteDO);
        return (Integer) id;
    }

    /**
     * 统计记录数
     * @param websiteDO
     * @return 查出的记录数
     */
    public Integer countWebsiteDOByExample(WebsiteDO websiteDO) throws DataAccessException {
        Integer count = (Integer) getSqlMapClientTemplate().queryForObject("Website.countByDOExample", websiteDO);
        return count;
    }

    /**
     * 更新记录
     * @param websiteDO
     * @return 受影响的行数
     */
    public Integer updateWebsiteDO(WebsiteDO websiteDO) throws DataAccessException {
        int result = getSqlMapClientTemplate().update("Website.update", websiteDO);
        return result;
    }

    /**
     * 获取对象列表
     * @param websiteDO
     * @return 对象列表
     */
    @SuppressWarnings("unchecked")
    public List<WebsiteDO> findListByExample(WebsiteDO websiteDO) throws DataAccessException {
        List<WebsiteDO> list = getSqlMapClientTemplate().queryForList("Website.findListByDO", websiteDO);
        return list;
    }

    /**
     * 根据主键获取websiteDO
     * @param id
     * @return websiteDO
     */
    public WebsiteDO findWebsiteDOByPrimaryKey(Integer id) throws DataAccessException {
        WebsiteDO websiteDO = (WebsiteDO) getSqlMapClientTemplate().queryForObject("Website.findByPrimaryKey", id);
        return websiteDO;
    }

    /**
     * 删除记录
     * @param id
     * @return 受影响的行数
     */
    public Integer deleteWebsiteDOByPrimaryKey(Integer id) throws DataAccessException {
        Integer rows = (Integer) getSqlMapClientTemplate().delete("Website.deleteByPrimaryKey", id);
        return rows;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<WebsiteDO> queryAll(Integer pageNum) throws DataAccessException {
        List<WebsiteDO> list = getSqlMapClientTemplate().queryForList("Website.queryAll", pageNum*20);
        return list;
    }

}