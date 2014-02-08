package com.hlx.birdhouse.dal.biz.dal.dao;

import com.hlx.birdhouse.dal.biz.dal.dataobject.ActionIpDO;
import java.util.List;
import org.springframework.dao.DataAccessException;

/**
 * ���ݷ��ʶ���ӿ�
 * @since 2013-09-02
 */
public interface ActionIpDAO {

    /**
     * ��������
     * @param actionIpDO
     * @return �������ݵ�����
     */
    public Integer insertActionIpDO(ActionIpDO actionIpDO) throws DataAccessException;

    /**
     * ͳ�Ƽ�¼��
     * @param actionIpDO
     * @return ����ļ�¼��
     */
    public Integer countActionIpDOByExample(ActionIpDO actionIpDO) throws DataAccessException;

    /**
     * ���¼�¼
     * @param actionIpDO
     * @return ��Ӱ�������
     */
    public Integer updateActionIpDO(ActionIpDO actionIpDO) throws DataAccessException;

    /**
     * ��ȡ�����б�
     * @param actionIpDO
     * @return �����б�
     */
    public List<ActionIpDO> findListByExample(ActionIpDO actionIpDO) throws DataAccessException;

    /**
     * ����������ȡactionIpDO
     * @param id
     * @return actionIpDO
     */
    public ActionIpDO findActionIpDOByPrimaryKey(Integer id) throws DataAccessException;

    /**
     * ɾ����¼
     * @param id
     * @return ��Ӱ�������
     */
    public Integer deleteActionIpDOByPrimaryKey(Integer id) throws DataAccessException;

}