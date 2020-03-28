package com.example.SpringBoot_mybatis.controller;

import com.example.SpringBoot_mybatis.entity.User;
import com.example.SpringBoot_mybatis.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Date;
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserControllerTest {

    @Resource
    private UserService userService;
    @Test
    public void selectOne() {
    }

    @Test
    public void getAll() {
    }

    @Test
    public void addUser() {
        User user = User.builder()
                .username("username")
                .birthday(new Date())
                .sex("男")
                .address("北京市")
                .build();
        user =  userService.insert(user);
        System.out.println(user);
    }
}