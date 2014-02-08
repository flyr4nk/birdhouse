package com.hlx.birdhouse.dal.biz.dal.dao;

import com.hlx.birdhouse.dal.biz.dal.dataobject.WebsiteDO;
import java.util.List;
import org.springframework.dao.DataAccessException;

/**
 * ���ݷ��ʶ���ӿ�
 * @since 2013-09-02
 */
public interface WebsiteDAO {

    /**
     * ��������
     * @param websiteDO
     * @return �������ݵ�����
     */
    public Integer insertWebsiteDO(WebsiteDO websiteDO) throws DataAccessException;

    /**
     * ͳ�Ƽ�¼��
     * @param websiteDO
     * @return ����ļ�¼��
     */
    public Integer countWebsiteDOByExample(WebsiteDO websiteDO) throws DataAccessException;

    /**
     * ���¼�¼
     * @param websiteDO
     * @return ��Ӱ�������
     */
    public Integer updateWebsiteDO(WebsiteDO websiteDO) throws DataAccessException;

    /**
     * ��ȡ�����б�
     * @param websiteDO
     * @return �����б�
     */
    public List<WebsiteDO> findListByExample(WebsiteDO websiteDO) throws DataAccessException;

    /**
     * ����������ȡwebsiteDO
     * @param id
     * @return websiteDO
     */
    public WebsiteDO findWebsiteDOByPrimaryKey(Integer id) throws DataAccessException;

    /**
     * ɾ����¼
     * @param id
     * @return ��Ӱ�������
     */
    public Integer deleteWebsiteDOByPrimaryKey(Integer id) throws DataAccessException;
    
    /**
     * ��ҳ��ѯ
     * @param pageNum
     * @return
     * @throws DataAccessException
     */
    public List<WebsiteDO> queryAll(Integer pageNum) throws DataAccessException;

}