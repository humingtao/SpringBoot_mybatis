package com.example.SpringBoot_mybatis.controller;

import com.example.SpringBoot_mybatis.annotation.UserLoginToken;
import com.example.SpringBoot_mybatis.entity.Result;
import com.example.SpringBoot_mybatis.entity.SpPermission;
import com.example.SpringBoot_mybatis.entity.User;
import com.example.SpringBoot_mybatis.service.SpPermissionService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 权限表(SpPermission)表控制层
 *
 * @author makejava
 * @since 2020-03-29 00:13:23
 */
@RestController
@RequestMapping("spPermission")
public class SpPermissionController {
    /**
     * 服务对象
     */
    @Resource
    private SpPermissionService spPermissionService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public SpPermission selectOne(String id) {
        return this.spPermissionService.queryById(id);
    }

    /**
     * 分页查询
     * @param pageNo
     * @param pageSize
     * @return
     */
    @UserLoginToken
    @GetMapping("getAll")
    public Result getAll(@RequestParam(defaultValue = "1") int pageNo, @RequestParam(defaultValue = "10") int pageSize, @RequestParam(required = false) String query) {
        PageHelper.startPage(pageNo, pageSize);
        PageInfo<SpPermission> userPageInfo = new PageInfo<>(spPermissionService.getAll(query));
        System.out.println(userPageInfo);
        return Result.retOK(userPageInfo);
    }

}