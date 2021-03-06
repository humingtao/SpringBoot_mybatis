package com.example.SpringBoot_mybatis.service.impl;

import com.example.SpringBoot_mybatis.entity.User;
import com.example.SpringBoot_mybatis.dao.UserDao;
import com.example.SpringBoot_mybatis.service.UserService;
import com.github.pagehelper.Page;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * (User)表服务实现类
 *
 * @author makejava
 * @since 2020-03-13 14:52:13
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;

    @Override
    public Page<User> getAll(String username) {
        return userDao.getAll(username);
    }

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public User queryById(Integer id) {
        return this.userDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<User> queryAllByLimit(int offset, int limit) {
        return this.userDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    @Override
    public User insert(User user) {
        this.userDao.insert(user);
        return user;
    }

    /**
     * 修改数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    @Override
    public User update(User user) {
        this.userDao.update(user);
        return this.queryById(user.getId());
    }

    @Override
    public User updateById(Integer id, Integer state) {
        User user = this.userDao.queryById(id);
        user.setIsActive(state);
        Integer i = this.userDao.update(user);
        return user;
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.userDao.deleteById(id) > 0;
    }

    @Override
    public List<Map> sexGroup() {
        return this.userDao.sexGroup();
    }
    @Override
    public List<Map> ageGroup() {
        return this.userDao.ageGroup();
    }

}