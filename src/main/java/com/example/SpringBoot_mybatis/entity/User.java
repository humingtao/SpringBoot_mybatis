package com.example.SpringBoot_mybatis.entity;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.io.Serializable;

/**
 * (User)实体类
 *
 * @author makejava
 * @since 2020-03-13 14:52:06
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class User implements Serializable {
    private static final long serialVersionUID = -50718597677119146L;
    
    private Integer id;
    /**
    * 用户名称
    */
    private String username;
    /**
    * 生日
    */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date birthday;
    /**
    * 性别
    */
    private String sex;
    /**
    * 地址
    */
    private String address;
    /**
     * 是否激活
     */
    private Integer isActive;

}