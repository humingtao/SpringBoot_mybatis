package com.example.SpringBoot_mybatis.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.io.Serializable;

/**
 * 用户表(SysUser)实体类
 *
 * @author makejava
 * @since 2020-03-24 20:21:15
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class SysUser implements Serializable {
    private static final long serialVersionUID = -65198246802884149L;
    /**
    * 用户ID
    */
    private String id;
    /**
    * 用户名
    */
    private String userName;
    /**
    * 密码
    */
    private String userPassword;
    /**
    * 邮箱
    */
    private String userEmail;
    /**
    * 简介
    */
    private String userInfo;
    /**
    * 头像
    */
    private Object headImg;
    /**
    * 创建时间
    */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;




}