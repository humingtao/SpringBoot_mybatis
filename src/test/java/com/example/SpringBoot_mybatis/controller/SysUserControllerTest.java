package com.example.SpringBoot_mybatis.controller;

import com.example.SpringBoot_mybatis.entity.SysUser;
import com.example.SpringBoot_mybatis.service.SysUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SysUserControllerTest {

    @Resource
    private SysUserService sysUserService;

    @Test
    public void testSelectOne() {
//        System.out.println(sysUserService.queryById("1"));
        SysUser sysUser = sysUserService.queryById("1");
    }

    @Test
    public void testLogin() {
//        System.out.println(sysUserService.queryById("1"));
        SysUser sysUser = sysUserService.queryByUsernameAndPassword("admin","123456");
        System.out.println(sysUser);
    }
}