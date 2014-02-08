package com.hlx.birdhouse.dal.biz.dal.dao;

import com.hlx.birdhouse.dal.biz.dal.dataobject.ActionIpDO;
import java.util.List;
import org.springframework.dao.DataAccessException;

/**
 * 数据访问对象接口
 * @since 2013-09-02
 */
public interface ActionIpDAO {

    /**
     * 插入数据
     * @param actionIpDO
     * @return 插入数据的主键
     */
    public Integer insertActionIpDO(ActionIpDO actionIpDO) throws DataAccessException;

    /**
     * 统计记录数
     * @param actionIpDO
     * @return 查出的记录数
     */
    public Integer countActionIpDOByExample(ActionIpDO actionIpDO) throws DataAccessException;

    /**
     * 更新记录
     * @param actionIpDO
     * @return 受影响的行数
     */
    public Integer updateActionIpDO(ActionIpDO actionIpDO) throws DataAccessException;

    /**
     * 获取对象列表
     * @param actionIpDO
     * @return 对象列表
     */
    public List<ActionIpDO> findListByExample(ActionIpDO actionIpDO) throws DataAccessException;

    /**
     * 根据主键获取actionIpDO
     * @param id
     * @return actionIpDO
     */
    public ActionIpDO findActionIpDOByPrimaryKey(Integer id) throws DataAccessException;

    /**
     * 删除记录
     * @param id
     * @return 受影响的行数
     */
    public Integer deleteActionIpDOByPrimaryKey(Integer id) throws DataAccessException;

}