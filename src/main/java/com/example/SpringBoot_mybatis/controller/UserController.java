package com.example.SpringBoot_mybatis.controller;
import java.util.ArrayList;
import	java.util.List;
import java.util.Optional;

import com.example.SpringBoot_mybatis.entity.User;
import com.example.SpringBoot_mybatis.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (User)表控制层
 *
 * @author makejava
 * @since 2020-03-13 14:52:14
 */
@RestController
@RequestMapping("user")
public class UserController {
    /**
     * 服务对象
     */
    @Resource
    private UserService userService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public User selectOne(Integer id) {
        User user = Optional.ofNullable(userService.queryById(id)).orElse(new User());
        return user;
    }

    @GetMapping("getAll")
    public PageInfo<User> getAll(@RequestParam(defaultValue = "1") int pageNo,@RequestParam(defaultValue = "10") int pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        PageInfo<User> userPageInfo = new PageInfo<>(userService.getAll());
        System.out.println(userPageInfo);
        return userPageInfo;
    }

}