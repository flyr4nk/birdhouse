package com.hlx.birdhouse.dal.biz.dal.dao.impl;

import com.hlx.birdhouse.dal.biz.dal.dao.ActionDAO;
import com.hlx.birdhouse.dal.biz.dal.dataobject.ActionDO;
import java.util.List;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

/**
 * 数据访问对象实现类
 * @since 2013-09-02
 */
public class ActionDAOImpl extends SqlMapClientDaoSupport implements ActionDAO {

    /**
     * 插入数据
     * @param actionDO
     * @return 插入数据的主键
     */
    public Integer insertActionDO(ActionDO actionDO) throws DataAccessException {
        Object id = getSqlMapClientTemplate().insert("Action.insert", actionDO);
        return (Integer) id;
    }

    /**
     * 统计记录数
     * @param actionDO
     * @return 查出的记录数
     */
    public Integer countActionDOByExample(ActionDO actionDO) throws DataAccessException {
        Integer count = (Integer) getSqlMapClientTemplate().queryForObject("Action.countByDOExample", actionDO);
        return count;
    }

    /**
     * 更新记录
     * @param actionDO
     * @return 受影响的行数
     */
    public Integer updateActionDO(ActionDO actionDO) throws DataAccessException {
        int result = getSqlMapClientTemplate().update("Action.update", actionDO);
        return result;
    }

    /**
     * 获取对象列表
     * @param actionDO
     * @return 对象列表
     */
    @SuppressWarnings("unchecked")
    public List<ActionDO> findListByExample(ActionDO actionDO) throws DataAccessException {
        List<ActionDO> list = getSqlMapClientTemplate().queryForList("Action.findListByDO", actionDO);
        return list;
    }

    /**
     * 根据主键获取actionDO
     * @param id
     * @return actionDO
     */
    public ActionDO findActionDOByPrimaryKey(Integer id) throws DataAccessException {
        ActionDO actionDO = (ActionDO) getSqlMapClientTemplate().queryForObject("Action.findByPrimaryKey", id);
        return actionDO;
    }

    /**
     * 删除记录
     * @param id
     * @return 受影响的行数
     */
    public Integer deleteActionDOByPrimaryKey(Integer id) throws DataAccessException {
        Integer rows = (Integer) getSqlMapClientTemplate().delete("Action.deleteByPrimaryKey", id);
        return rows;
    }

    @Override
    public void deleteByWid(Integer wid) {
        getSqlMapClientTemplate().delete("Action.deleteByWid", wid);
    }

}