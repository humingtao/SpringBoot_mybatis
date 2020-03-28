package com.example.SpringBoot_mybatis.dao;

import com.example.SpringBoot_mybatis.entity.SpPermission;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 权限表(SpPermission)表数据库访问层
 *
 * @author makejava
 * @since 2020-03-29 00:13:23
 */
public interface SpPermissionDao {

    /**
     * 通过ID查询单条数据
     *
     * @param psId 主键
     * @return 实例对象
     */
    SpPermission queryById(String psId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<SpPermission> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param spPermission 实例对象
     * @return 对象列表
     */
    List<SpPermission> queryAll(SpPermission spPermission);

    /**
     * 新增数据
     *
     * @param spPermission 实例对象
     * @return 影响行数
     */
    int insert(SpPermission spPermission);

    /**
     * 修改数据
     *
     * @param spPermission 实例对象
     * @return 影响行数
     */
    int update(SpPermission spPermission);

    /**
     * 通过主键删除数据
     *
     * @param psId 主键
     * @return 影响行数
     */
    int deleteById(String psId);

    Page<SpPermission> getAll(String username);
}