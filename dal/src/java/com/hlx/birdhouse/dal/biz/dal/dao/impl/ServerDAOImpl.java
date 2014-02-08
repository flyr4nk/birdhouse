package com.hlx.birdhouse.dal.biz.dal.dao.impl;

import com.hlx.birdhouse.dal.biz.dal.dao.ServerDAO;
import com.hlx.birdhouse.dal.biz.dal.dataobject.ServerDO;
import java.util.List;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

/**
 * 数据访问对象实现类
 * @since 2013-09-03
 */
public class ServerDAOImpl extends SqlMapClientDaoSupport implements ServerDAO {

    /**
     * 插入数据
     * @param serverDO
     * @return 插入数据的主键
     */
    public Integer insertServerDO(ServerDO serverDO) throws DataAccessException {
        Object id = getSqlMapClientTemplate().insert("Server.insert", serverDO);
        return (Integer) id;
    }

    /**
     * 统计记录数
     * @param serverDO
     * @return 查出的记录数
     */
    public Integer countServerDOByExample(ServerDO serverDO) throws DataAccessException {
        Integer count = (Integer) getSqlMapClientTemplate().queryForObject("Server.countByDOExample", serverDO);
        return count;
    }

    /**
     * 更新记录
     * @param serverDO
     * @return 受影响的行数
     */
    public Integer updateServerDO(ServerDO serverDO) throws DataAccessException {
        int result = getSqlMapClientTemplate().update("Server.update", serverDO);
        return result;
    }
    
    /**
     * 更新记录
     * @param serverDO
     * @return 受影响的行数
     */
    public Integer updateServerStatus(ServerDO serverDO) throws DataAccessException {
        int result = getSqlMapClientTemplate().update("Server.updateStatus", serverDO);
        return result;
    }

    /**
     * 获取对象列表
     * @param serverDO
     * @return 对象列表
     */
    @SuppressWarnings("unchecked")
    public List<ServerDO> findListByExample(ServerDO serverDO) throws DataAccessException {
        List<ServerDO> list = getSqlMapClientTemplate().queryForList("Server.findListByDO", serverDO);
        return list;
    }

    /**
     * 根据主键获取serverDO
     * @param id
     * @return serverDO
     */
    public ServerDO findServerDOByPrimaryKey(Integer id) throws DataAccessException {
        ServerDO serverDO = (ServerDO) getSqlMapClientTemplate().queryForObject("Server.findByPrimaryKey", id);
        return serverDO;
    }

    /**
     * 删除记录
     * @param id
     * @return 受影响的行数
     */
    public Integer deleteServerDOByPrimaryKey(Integer id) throws DataAccessException {
        Integer rows = (Integer) getSqlMapClientTemplate().delete("Server.deleteByPrimaryKey", id);
        return rows;
    }

    @Override
    public void deleteByWid(Integer wid) {
        getSqlMapClientTemplate().delete("Server.deleteByWid", wid);
    }

}