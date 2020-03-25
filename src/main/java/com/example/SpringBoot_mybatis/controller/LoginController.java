package com.example.SpringBoot_mybatis.controller;

import com.example.SpringBoot_mybatis.entity.Result;
import com.example.SpringBoot_mybatis.entity.User;
import com.example.SpringBoot_mybatis.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Optional;

/**
 * @author 胡明涛
 * @date 2020-3-24
 * @todo 用户登录层
 */
@RestController
@RequestMapping("login")
public class LoginController {
    /**
     * user服务对象
     */
    @Resource
    private UserService userService;

    /**
     * 通过主键查询单条数据
     * @param username 用户名
     * @param password 密码
     * @return 单条数据
     */
    @GetMapping("getLogin")
    public Result selectOne(@RequestParam String username,@RequestParam String password) {
        User user = new User();
        return Result.retOK(user);
    }

}
