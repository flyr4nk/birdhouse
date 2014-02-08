package com.hlx.birdhouse.dal.biz.dal.dao.impl;

import com.hlx.birdhouse.dal.biz.dal.dao.ActionIpDAO;
import com.hlx.birdhouse.dal.biz.dal.dataobject.ActionIpDO;
import java.util.List;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

/**
 * ���ݷ��ʶ���ʵ����
 * @since 2013-09-02
 */
public class ActionIpDAOImpl extends SqlMapClientDaoSupport implements ActionIpDAO {

    /**
     * ��������
     * @param actionIpDO
     * @return �������ݵ�����
     */
    public Integer insertActionIpDO(ActionIpDO actionIpDO) throws DataAccessException {
        Object id = getSqlMapClientTemplate().insert("ActionIp.insert", actionIpDO);
        return (Integer) id;
    }

    /**
     * ͳ�Ƽ�¼��
     * @param actionIpDO
     * @return ����ļ�¼��
     */
    public Integer countActionIpDOByExample(ActionIpDO actionIpDO) throws DataAccessException {
        Integer count = (Integer) getSqlMapClientTemplate().queryForObject("ActionIp.countByDOExample", actionIpDO);
        return count;
    }

    /**
     * ���¼�¼
     * @param actionIpDO
     * @return ��Ӱ�������
     */
    public Integer updateActionIpDO(ActionIpDO actionIpDO) throws DataAccessException {
        int result = getSqlMapClientTemplate().update("ActionIp.update", actionIpDO);
        return result;
    }

    /**
     * ��ȡ�����б�
     * @param actionIpDO
     * @return �����б�
     */
    @SuppressWarnings("unchecked")
    public List<ActionIpDO> findListByExample(ActionIpDO actionIpDO) throws DataAccessException {
        List<ActionIpDO> list = getSqlMapClientTemplate().queryForList("ActionIp.findListByDO", actionIpDO);
        return list;
    }

    /**
     * ����������ȡactionIpDO
     * @param id
     * @return actionIpDO
     */
    public ActionIpDO findActionIpDOByPrimaryKey(Integer id) throws DataAccessException {
        ActionIpDO actionIpDO = (ActionIpDO) getSqlMapClientTemplate().queryForObject("ActionIp.findByPrimaryKey", id);
        return actionIpDO;
    }

    /**
     * ɾ����¼
     * @param id
     * @return ��Ӱ�������
     */
    public Integer deleteActionIpDOByPrimaryKey(Integer id) throws DataAccessException {
        Integer rows = (Integer) getSqlMapClientTemplate().delete("ActionIp.deleteByPrimaryKey", id);
        return rows;
    }

}