package com.hlx.birdhouse.dal.biz.dal.dao.impl;

import com.hlx.birdhouse.dal.biz.dal.dao.WebsiteDAO;
import com.hlx.birdhouse.dal.biz.dal.dataobject.WebsiteDO;
import java.util.List;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

/**
 * ���ݷ��ʶ���ʵ����
 * @since 2013-09-02
 */
public class WebsiteDAOImpl extends SqlMapClientDaoSupport implements WebsiteDAO {

    /**
     * ��������
     * @param websiteDO
     * @return �������ݵ�����
     */
    public Integer insertWebsiteDO(WebsiteDO websiteDO) throws DataAccessException {
        Object id = getSqlMapClientTemplate().insert("Website.insert", websiteDO);
        return (Integer) id;
    }

    /**
     * ͳ�Ƽ�¼��
     * @param websiteDO
     * @return ����ļ�¼��
     */
    public Integer countWebsiteDOByExample(WebsiteDO websiteDO) throws DataAccessException {
        Integer count = (Integer) getSqlMapClientTemplate().queryForObject("Website.countByDOExample", websiteDO);
        return count;
    }

    /**
     * ���¼�¼
     * @param websiteDO
     * @return ��Ӱ�������
     */
    public Integer updateWebsiteDO(WebsiteDO websiteDO) throws DataAccessException {
        int result = getSqlMapClientTemplate().update("Website.update", websiteDO);
        return result;
    }

    /**
     * ��ȡ�����б�
     * @param websiteDO
     * @return �����б�
     */
    @SuppressWarnings("unchecked")
    public List<WebsiteDO> findListByExample(WebsiteDO websiteDO) throws DataAccessException {
        List<WebsiteDO> list = getSqlMapClientTemplate().queryForList("Website.findListByDO", websiteDO);
        return list;
    }

    /**
     * ����������ȡwebsiteDO
     * @param id
     * @return websiteDO
     */
    public WebsiteDO findWebsiteDOByPrimaryKey(Integer id) throws DataAccessException {
        WebsiteDO websiteDO = (WebsiteDO) getSqlMapClientTemplate().queryForObject("Website.findByPrimaryKey", id);
        return websiteDO;
    }

    /**
     * ɾ����¼
     * @param id
     * @return ��Ӱ�������
     */
    public Integer deleteWebsiteDOByPrimaryKey(Integer id) throws DataAccessException {
        Integer rows = (Integer) getSqlMapClientTemplate().delete("Website.deleteByPrimaryKey", id);
        return rows;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<WebsiteDO> queryAll(Integer pageNum) throws DataAccessException {
        List<WebsiteDO> list = getSqlMapClientTemplate().queryForList("Website.queryAll", pageNum*20);
        return list;
    }

}