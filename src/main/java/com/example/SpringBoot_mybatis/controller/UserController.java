package com.example.SpringBoot_mybatis.controller;

import com.example.SpringBoot_mybatis.annotation.UserLoginToken;
import com.example.SpringBoot_mybatis.entity.Result;
import com.example.SpringBoot_mybatis.entity.User;
import com.example.SpringBoot_mybatis.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import javax.annotation.Resource;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

/**
 * (User)表控制层
 *
 * @author hmt
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
     * @param id 主键
     * @return 单条数据
     */
    @UserLoginToken
    @GetMapping("selectOne")
    public Result selectOne(@RequestParam Integer id) {
        User user = userService.queryById(id);
        boolean b = Optional.ofNullable(user).isPresent();
        if (b) {
            return Result.retOK(user);
        } else {
            return Result.retOK();
        }
    }

    /**
     * 通过主键删除单条数据
     * @param id 主键
     * @return 单条数据
     */
    @UserLoginToken
    @DeleteMapping("deleteById")
    public Result deleteById(@RequestParam Integer id) {
        boolean flag = userService.deleteById(id);
        return Result.retOK(flag);
    }

    /**
     * 分页查询
     * @param pageNo
     * @param pageSize
     * @return
     */
    @UserLoginToken
    @GetMapping("getAll")
    public Result getAll(@RequestParam(defaultValue = "1") int pageNo,@RequestParam(defaultValue = "10") int pageSize, @RequestParam(required = false) String username) {
        PageHelper.startPage(pageNo, pageSize);
        PageInfo<User> userPageInfo = new PageInfo<>(userService.getAll(username));
        System.out.println(userPageInfo);
        return Result.retOK(userPageInfo);
    }

    /**
     * 添加用户
     * @return
     */
    @UserLoginToken
    @PutMapping("/addUser")
    public Result addUser(User user) {
        user =  userService.insert(user);
        return Result.retOK(user);
    }
    /**
     * 添加用户
     * @return
     */
    @UserLoginToken
    @PutMapping("/updateUser")
    public Result updateUser(@RequestParam Integer id,@RequestParam Date birthday,@RequestParam String sex,@RequestParam String address) {
        User user = Optional.ofNullable(userService.queryById(id)).orElse(new User());
        user.setBirthday(birthday);
        user.setSex(sex);
        user.setAddress(address);
        user =  userService.update(user);
        return Result.retOK(user);
    }

    /**
     * 字符串转日期
     * @param binder
     * @param request
     */
    @InitBinder
    public void initBinder(WebDataBinder binder, WebRequest request) {
        //转换日期 注意这里的转化要和传进来的字符串的格式一直 如2015-9-9 就应该为yyyy-MM-dd
        DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));// CustomDateEditor为自定义日期编辑器
    }

}