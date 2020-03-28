package com.example.SpringBoot_mybatis.service;

import com.example.SpringBoot_mybatis.entity.SpPermission;
import com.example.SpringBoot_mybatis.entity.User;
import com.github.pagehelper.Page;

import java.util.List;

/**
 * 权限表(SpPermission)表服务接口
 *
 * @author makejava
 * @since 2020-03-29 00:13:23
 */
public interface SpPermissionService {
    Page<SpPermission> getAll(String username);
    /**
     * 通过ID查询单条数据
     *
     * @param psId 主键
     * @return 实例对象
     */
    SpPermission queryById(String psId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<SpPermission> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param spPermission 实例对象
     * @return 实例对象
     */
    SpPermission insert(SpPermission spPermission);

    /**
     * 修改数据
     *
     * @param spPermission 实例对象
     * @return 实例对象
     */
    SpPermission update(SpPermission spPermission);

    /**
     * 通过主键删除数据
     *
     * @param psId 主键
     * @return 是否成功
     */
    boolean deleteById(String psId);

}