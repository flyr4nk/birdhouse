package com.hlx.birdhouse.dal.biz.dal.dao;

import com.hlx.birdhouse.dal.biz.dal.dataobject.ServerDO;
import java.util.List;
import org.springframework.dao.DataAccessException;

/**
 * 数据访问对象接口
 * @since 2013-09-03
 */
public interface ServerDAO {

    /**
     * 插入数据
     * @param serverDO
     * @return 插入数据的主键
     */
    public Integer insertServerDO(ServerDO serverDO) throws DataAccessException;

    /**
     * 统计记录数
     * @param serverDO
     * @return 查出的记录数
     */
    public Integer countServerDOByExample(ServerDO serverDO) throws DataAccessException;

    /**
     * 更新记录
     * @param serverDO
     * @return 受影响的行数
     */
    public Integer updateServerDO(ServerDO serverDO) throws DataAccessException;
    
    /**
     * 更新状态
     * @param serverDO
     * @return 受影响的行数
     */
    public Integer updateServerStatus(ServerDO serverDO) throws DataAccessException;
    
    /**
     * 获取对象列表
     * @param serverDO
     * @return 对象列表
     */
    public List<ServerDO> findListByExample(ServerDO serverDO) throws DataAccessException;

    /**
     * 根据主键获取serverDO
     * @param id
     * @return serverDO
     */
    public ServerDO findServerDOByPrimaryKey(Integer id) throws DataAccessException;

    /**
     * 删除记录
     * @param id
     * @return 受影响的行数
     */
    public Integer deleteServerDOByPrimaryKey(Integer id) throws DataAccessException;
    
    /**
     * 根据wid删除记录
     * @param wid
     */
    public void deleteByWid(Integer wid);

}