package com.example.SpringBoot_mybatis.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.SpringBoot_mybatis.entity.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("menu")
public class MenuController {

    @GetMapping("menu")
    public Result selectOne() {
        JSONArray jsonArray = new JSONArray();
        JSONObject jsonObjectChirden = new JSONObject();
        jsonObjectChirden.put("id","1");
        jsonObjectChirden.put("authName","用户列表");
        jsonObjectChirden.put("path","page");
        jsonObjectChirden.put("children",null);
        JSONArray jsonArray1 = new JSONArray();
        jsonArray1.add(jsonObjectChirden);



        JSONObject jsonObjectChirden1 = new JSONObject();
        jsonObjectChirden1.put("id","1");
        jsonObjectChirden1.put("authName","进入首页");
        jsonObjectChirden1.put("path","welcome");
        jsonObjectChirden1.put("children",null);
        JSONArray jsonArray2 = new JSONArray();
        jsonArray2.add(jsonObjectChirden1);


        JSONObject jsonObject1 = new JSONObject();
        jsonObject1.put("id","110");
        jsonObject1.put("authName","首页");
        jsonObject1.put("path",null);
        jsonObject1.put("children",jsonArray2);
        jsonObject1.put("order","2");
        jsonArray.add(jsonObject1);
        JSONObject jsonObject2 = new JSONObject();
        jsonObject2.put("id","111");
        jsonObject2.put("authName","用户管理");
        jsonObject2.put("path",null);
        jsonObject2.put("children",jsonArray1);
        jsonObject2.put("order","3");
        jsonArray.add(jsonObject2);
        JSONObject jsonObject3 = new JSONObject();
        JSONObject jsonObjectChirden3 = new JSONObject();
        jsonObjectChirden3.put("id","1");
        jsonObjectChirden3.put("authName","权限列表");
        jsonObjectChirden3.put("path","perssion");
        jsonObjectChirden3.put("children",null);
        JSONArray jsonArray3 = new JSONArray();
        jsonArray3.add(jsonObjectChirden3);
        jsonObject3.put("id","112");
        jsonObject3.put("authName","权限管理");
        jsonObject3.put("path",null);
        jsonObject3.put("children",jsonArray3);
        jsonObject3.put("order","4");
        jsonArray.add(jsonObject3);
        JSONObject jsonObject4 = new JSONObject();

        JSONObject jsonObjectChirden4 = new JSONObject();
        jsonObjectChirden4.put("id","113");
        jsonObjectChirden4.put("authName","以性别");
        jsonObjectChirden4.put("path","analysis");
        jsonObjectChirden4.put("children",null);
        JSONObject jsonObjectChirden5 = new JSONObject();
        jsonObjectChirden5.put("id","114");
        jsonObjectChirden5.put("authName","以年龄");
        jsonObjectChirden5.put("path","useage");
        jsonObjectChirden5.put("children",null);
        JSONArray jsonArray4 = new JSONArray();
        jsonArray4.add(jsonObjectChirden4);
        jsonArray4.add(jsonObjectChirden5);
        jsonObject4.put("id","113");
        jsonObject4.put("authName","人员分组");
        jsonObject4.put("path",null);
        jsonObject4.put("children",jsonArray4);
        jsonObject4.put("order","5");
        jsonArray.add(jsonObject4);

        return Result.retOK(jsonArray);
    }
}
