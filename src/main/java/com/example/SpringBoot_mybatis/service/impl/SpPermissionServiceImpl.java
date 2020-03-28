package com.example.SpringBoot_mybatis.service.impl;

import com.example.SpringBoot_mybatis.entity.SpPermission;
import com.example.SpringBoot_mybatis.dao.SpPermissionDao;
import com.example.SpringBoot_mybatis.service.SpPermissionService;
import com.github.pagehelper.Page;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 权限表(SpPermission)表服务实现类
 *
 * @author makejava
 * @since 2020-03-29 00:13:23
 */
@Service("spPermissionService")
public class SpPermissionServiceImpl implements SpPermissionService {
    @Resource
    private SpPermissionDao spPermissionDao;

    @Override
    public Page<SpPermission> getAll(String username) {
        return spPermissionDao.getAll(username);
    }

    /**
     * 通过ID查询单条数据
     *
     * @param psId 主键
     * @return 实例对象
     */
    @Override
    public SpPermission queryById(String psId) {
        return this.spPermissionDao.queryById(psId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<SpPermission> queryAllByLimit(int offset, int limit) {
        return this.spPermissionDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param spPermission 实例对象
     * @return 实例对象
     */
    @Override
    public SpPermission insert(SpPermission spPermission) {
        this.spPermissionDao.insert(spPermission);
        return spPermission;
    }

    /**
     * 修改数据
     *
     * @param spPermission 实例对象
     * @return 实例对象
     */
    @Override
    public SpPermission update(SpPermission spPermission) {
        this.spPermissionDao.update(spPermission);
        return this.queryById(spPermission.getPsId());
    }

    /**
     * 通过主键删除数据
     *
     * @param psId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String psId) {
        return this.spPermissionDao.deleteById(psId) > 0;
    }
}