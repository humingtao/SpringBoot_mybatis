package com.example.SpringBoot_mybatis.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.SpringBoot_mybatis.annotation.UserLoginToken;
import com.example.SpringBoot_mybatis.enmu.ResultCode;
import com.example.SpringBoot_mybatis.entity.Result;
import com.example.SpringBoot_mybatis.entity.SysUser;
import com.example.SpringBoot_mybatis.entity.User;
import com.example.SpringBoot_mybatis.service.SysUserService;
import com.example.SpringBoot_mybatis.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Optional;

import static com.example.SpringBoot_mybatis.enmu.ResultCode.ERROR;

/**
 * 用户表(SysUser)表控制层
 * @author hmt
 * @since 2020-03-24 20:21:15
 */
@RestController
@RequestMapping("sysUser")
public class SysUserController {
    /**
     * 服务对象
     */
    @Resource
    private SysUserService sysUserService;
    @Resource
    private TokenService tokenService;

    /**
     * 通过主键查询单条数据
     * @param id 主键
     * @return 单条数据
     */
    @UserLoginToken
    @GetMapping("selectOne")
    public Result selectOne(String id) {
        SysUser sysUser = sysUserService.queryById(id);
        boolean b = Optional.ofNullable(sysUser).isPresent();
        if (b) {
            return Result.retOK(sysUser);
        } else {
            return Result.retOK();
        }
    }

    /**
     * 添加用户
     * @return
     */
    @PutMapping("/addSysuser")
    public Result addUser(@RequestParam String username,
                          @RequestParam String password,
                          @RequestParam String info) {
        SysUser sysUser = SysUser.builder()
                .userInfo(info)
                .userName(username)
                .userPassword(password)
                .userEmail("454@qq.com")
                .createTime(new Date())
                .build();
        sysUser =  sysUserService.insert(sysUser);
        boolean b = Optional.ofNullable(sysUser).isPresent();
        if (b) {
            return Result.retOK(sysUser);
        } else {
            return Result.retFail(ResultCode.ERROR);
        }
    }


    /**
     * 通过用户名&密码查询单条数据
     * @param username 用户名
     * @param password 密码
     * @return 单条数据
     */

    @GetMapping("getSysuser")
    public Result selectOne(@RequestParam String username,@RequestParam String password) {
        SysUser sysUser = sysUserService.queryByUsernameAndPassword(username, password);
        boolean b = Optional.ofNullable(sysUser).isPresent();
        if (b) {
            String token = tokenService.getToken(sysUser);
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("token", token);
            jsonObject.put("user", sysUser);
            return Result.retOK(jsonObject);
        } else {
            return Result.retFail(ERROR);
        }
    }

}