package com.hlx.birdhouse.dal.biz.dal.dao;

import com.hlx.birdhouse.dal.biz.dal.dataobject.ActionDO;
import java.util.List;
import org.springframework.dao.DataAccessException;

/**
 * 数据访问对象接口
 * @since 2013-09-02
 */
public interface ActionDAO {

    /**
     * 插入数据
     * @param actionDO
     * @return 插入数据的主键
     */
    public Integer insertActionDO(ActionDO actionDO) throws DataAccessException;

    /**
     * 统计记录数
     * @param actionDO
     * @return 查出的记录数
     */
    public Integer countActionDOByExample(ActionDO actionDO) throws DataAccessException;

    /**
     * 更新记录
     * @param actionDO
     * @return 受影响的行数
     */
    public Integer updateActionDO(ActionDO actionDO) throws DataAccessException;

    /**
     * 获取对象列表
     * @param actionDO
     * @return 对象列表
     */
    public List<ActionDO> findListByExample(ActionDO actionDO) throws DataAccessException;

    /**
     * 根据主键获取actionDO
     * @param id
     * @return actionDO
     */
    public ActionDO findActionDOByPrimaryKey(Integer id) throws DataAccessException;

    /**
     * 删除记录
     * @param id
     * @return 受影响的行数
     */
    public Integer deleteActionDOByPrimaryKey(Integer id) throws DataAccessException;
    
    /**
     * 根据wid删除记录
     * @param wid
     */
    public void deleteByWid(Integer wid);

}