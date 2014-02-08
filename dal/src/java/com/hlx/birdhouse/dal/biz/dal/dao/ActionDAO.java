package com.hlx.birdhouse.dal.biz.dal.dao;

import com.hlx.birdhouse.dal.biz.dal.dataobject.ActionDO;
import java.util.List;
import org.springframework.dao.DataAccessException;

/**
 * ���ݷ��ʶ���ӿ�
 * @since 2013-09-02
 */
public interface ActionDAO {

    /**
     * ��������
     * @param actionDO
     * @return �������ݵ�����
     */
    public Integer insertActionDO(ActionDO actionDO) throws DataAccessException;

    /**
     * ͳ�Ƽ�¼��
     * @param actionDO
     * @return ����ļ�¼��
     */
    public Integer countActionDOByExample(ActionDO actionDO) throws DataAccessException;

    /**
     * ���¼�¼
     * @param actionDO
     * @return ��Ӱ�������
     */
    public Integer updateActionDO(ActionDO actionDO) throws DataAccessException;

    /**
     * ��ȡ�����б�
     * @param actionDO
     * @return �����б�
     */
    public List<ActionDO> findListByExample(ActionDO actionDO) throws DataAccessException;

    /**
     * ����������ȡactionDO
     * @param id
     * @return actionDO
     */
    public ActionDO findActionDOByPrimaryKey(Integer id) throws DataAccessException;

    /**
     * ɾ����¼
     * @param id
     * @return ��Ӱ�������
     */
    public Integer deleteActionDOByPrimaryKey(Integer id) throws DataAccessException;
    
    /**
     * ����widɾ����¼
     * @param wid
     */
    public void deleteByWid(Integer wid);

}