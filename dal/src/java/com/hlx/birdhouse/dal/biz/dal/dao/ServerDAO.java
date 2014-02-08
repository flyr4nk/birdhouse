package com.hlx.birdhouse.dal.biz.dal.dao;

import com.hlx.birdhouse.dal.biz.dal.dataobject.ServerDO;
import java.util.List;
import org.springframework.dao.DataAccessException;

/**
 * ���ݷ��ʶ���ӿ�
 * @since 2013-09-03
 */
public interface ServerDAO {

    /**
     * ��������
     * @param serverDO
     * @return �������ݵ�����
     */
    public Integer insertServerDO(ServerDO serverDO) throws DataAccessException;

    /**
     * ͳ�Ƽ�¼��
     * @param serverDO
     * @return ����ļ�¼��
     */
    public Integer countServerDOByExample(ServerDO serverDO) throws DataAccessException;

    /**
     * ���¼�¼
     * @param serverDO
     * @return ��Ӱ�������
     */
    public Integer updateServerDO(ServerDO serverDO) throws DataAccessException;
    
    /**
     * ����״̬
     * @param serverDO
     * @return ��Ӱ�������
     */
    public Integer updateServerStatus(ServerDO serverDO) throws DataAccessException;
    
    /**
     * ��ȡ�����б�
     * @param serverDO
     * @return �����б�
     */
    public List<ServerDO> findListByExample(ServerDO serverDO) throws DataAccessException;

    /**
     * ����������ȡserverDO
     * @param id
     * @return serverDO
     */
    public ServerDO findServerDOByPrimaryKey(Integer id) throws DataAccessException;

    /**
     * ɾ����¼
     * @param id
     * @return ��Ӱ�������
     */
    public Integer deleteServerDOByPrimaryKey(Integer id) throws DataAccessException;
    
    /**
     * ����widɾ����¼
     * @param wid
     */
    public void deleteByWid(Integer wid);

}