package com.hlx.birdhouse.dal.biz.dal.dao.impl;

import com.hlx.birdhouse.dal.biz.dal.dao.ServerDAO;
import com.hlx.birdhouse.dal.biz.dal.dataobject.ServerDO;
import java.util.List;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

/**
 * ���ݷ��ʶ���ʵ����
 * @since 2013-09-03
 */
public class ServerDAOImpl extends SqlMapClientDaoSupport implements ServerDAO {

    /**
     * ��������
     * @param serverDO
     * @return �������ݵ�����
     */
    public Integer insertServerDO(ServerDO serverDO) throws DataAccessException {
        Object id = getSqlMapClientTemplate().insert("Server.insert", serverDO);
        return (Integer) id;
    }

    /**
     * ͳ�Ƽ�¼��
     * @param serverDO
     * @return ����ļ�¼��
     */
    public Integer countServerDOByExample(ServerDO serverDO) throws DataAccessException {
        Integer count = (Integer) getSqlMapClientTemplate().queryForObject("Server.countByDOExample", serverDO);
        return count;
    }

    /**
     * ���¼�¼
     * @param serverDO
     * @return ��Ӱ�������
     */
    public Integer updateServerDO(ServerDO serverDO) throws DataAccessException {
        int result = getSqlMapClientTemplate().update("Server.update", serverDO);
        return result;
    }
    
    /**
     * ���¼�¼
     * @param serverDO
     * @return ��Ӱ�������
     */
    public Integer updateServerStatus(ServerDO serverDO) throws DataAccessException {
        int result = getSqlMapClientTemplate().update("Server.updateStatus", serverDO);
        return result;
    }

    /**
     * ��ȡ�����б�
     * @param serverDO
     * @return �����б�
     */
    @SuppressWarnings("unchecked")
    public List<ServerDO> findListByExample(ServerDO serverDO) throws DataAccessException {
        List<ServerDO> list = getSqlMapClientTemplate().queryForList("Server.findListByDO", serverDO);
        return list;
    }

    /**
     * ����������ȡserverDO
     * @param id
     * @return serverDO
     */
    public ServerDO findServerDOByPrimaryKey(Integer id) throws DataAccessException {
        ServerDO serverDO = (ServerDO) getSqlMapClientTemplate().queryForObject("Server.findByPrimaryKey", id);
        return serverDO;
    }

    /**
     * ɾ����¼
     * @param id
     * @return ��Ӱ�������
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