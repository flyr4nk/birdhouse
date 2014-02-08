package com.hlx.birdhouse.dal.biz.dal.dao.impl;

import com.hlx.birdhouse.dal.biz.dal.dao.ActionDAO;
import com.hlx.birdhouse.dal.biz.dal.dataobject.ActionDO;
import java.util.List;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

/**
 * ���ݷ��ʶ���ʵ����
 * @since 2013-09-02
 */
public class ActionDAOImpl extends SqlMapClientDaoSupport implements ActionDAO {

    /**
     * ��������
     * @param actionDO
     * @return �������ݵ�����
     */
    public Integer insertActionDO(ActionDO actionDO) throws DataAccessException {
        Object id = getSqlMapClientTemplate().insert("Action.insert", actionDO);
        return (Integer) id;
    }

    /**
     * ͳ�Ƽ�¼��
     * @param actionDO
     * @return ����ļ�¼��
     */
    public Integer countActionDOByExample(ActionDO actionDO) throws DataAccessException {
        Integer count = (Integer) getSqlMapClientTemplate().queryForObject("Action.countByDOExample", actionDO);
        return count;
    }

    /**
     * ���¼�¼
     * @param actionDO
     * @return ��Ӱ�������
     */
    public Integer updateActionDO(ActionDO actionDO) throws DataAccessException {
        int result = getSqlMapClientTemplate().update("Action.update", actionDO);
        return result;
    }

    /**
     * ��ȡ�����б�
     * @param actionDO
     * @return �����б�
     */
    @SuppressWarnings("unchecked")
    public List<ActionDO> findListByExample(ActionDO actionDO) throws DataAccessException {
        List<ActionDO> list = getSqlMapClientTemplate().queryForList("Action.findListByDO", actionDO);
        return list;
    }

    /**
     * ����������ȡactionDO
     * @param id
     * @return actionDO
     */
    public ActionDO findActionDOByPrimaryKey(Integer id) throws DataAccessException {
        ActionDO actionDO = (ActionDO) getSqlMapClientTemplate().queryForObject("Action.findByPrimaryKey", id);
        return actionDO;
    }

    /**
     * ɾ����¼
     * @param id
     * @return ��Ӱ�������
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