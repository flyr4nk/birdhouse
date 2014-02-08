package com.hlx.birdhouse.dal.biz.dal.dao.impl;

import com.hlx.birdhouse.dal.biz.dal.dao.ActionIpDAO;
import com.hlx.birdhouse.dal.biz.dal.dataobject.ActionIpDO;
import java.util.List;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

/**
 * 数据访问对象实现类
 * @since 2013-09-02
 */
public class ActionIpDAOImpl extends SqlMapClientDaoSupport implements ActionIpDAO {

    /**
     * 插入数据
     * @param actionIpDO
     * @return 插入数据的主键
     */
    public Integer insertActionIpDO(ActionIpDO actionIpDO) throws DataAccessException {
        Object id = getSqlMapClientTemplate().insert("ActionIp.insert", actionIpDO);
        return (Integer) id;
    }

    /**
     * 统计记录数
     * @param actionIpDO
     * @return 查出的记录数
     */
    public Integer countActionIpDOByExample(ActionIpDO actionIpDO) throws DataAccessException {
        Integer count = (Integer) getSqlMapClientTemplate().queryForObject("ActionIp.countByDOExample", actionIpDO);
        return count;
    }

    /**
     * 更新记录
     * @param actionIpDO
     * @return 受影响的行数
     */
    public Integer updateActionIpDO(ActionIpDO actionIpDO) throws DataAccessException {
        int result = getSqlMapClientTemplate().update("ActionIp.update", actionIpDO);
        return result;
    }

    /**
     * 获取对象列表
     * @param actionIpDO
     * @return 对象列表
     */
    @SuppressWarnings("unchecked")
    public List<ActionIpDO> findListByExample(ActionIpDO actionIpDO) throws DataAccessException {
        List<ActionIpDO> list = getSqlMapClientTemplate().queryForList("ActionIp.findListByDO", actionIpDO);
        return list;
    }

    /**
     * 根据主键获取actionIpDO
     * @param id
     * @return actionIpDO
     */
    public ActionIpDO findActionIpDOByPrimaryKey(Integer id) throws DataAccessException {
        ActionIpDO actionIpDO = (ActionIpDO) getSqlMapClientTemplate().queryForObject("ActionIp.findByPrimaryKey", id);
        return actionIpDO;
    }

    /**
     * 删除记录
     * @param id
     * @return 受影响的行数
     */
    public Integer deleteActionIpDOByPrimaryKey(Integer id) throws DataAccessException {
        Integer rows = (Integer) getSqlMapClientTemplate().delete("ActionIp.deleteByPrimaryKey", id);
        return rows;
    }

}