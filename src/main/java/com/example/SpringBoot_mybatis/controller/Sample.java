package com.example.SpringBoot_mybatis.controller;

import com.baidu.aip.nlp.AipNlp;
import org.json.JSONObject;

import java.util.HashMap;

public class Sample {
    //设置APPID/AK/SK
    public static final String APP_ID = "19161345";
    public static final String API_KEY = "9kelOK7b9rArgMmTCY22SI1n";
    public static final String SECRET_KEY = "x7h9inlafksRyKWzWIgl6h1UIE4EOjOP";

    public static void main(String[] args) {
        // 初始化一个AipNlp
        AipNlp client = new AipNlp(APP_ID, API_KEY, SECRET_KEY);

        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);

        // 可选：设置代理服务器地址, http和socket二选一，或者均不设置
//        client.setHttpProxy("proxy_host", proxy_port);  // 设置http代理
//        client.setSocketProxy("proxy_host", proxy_port);  // 设置socket代理
        // 传入可选参数调用接口
        HashMap<String, Object> options = new HashMap<String, Object>();
        // 调用接口
        String text = "我不想工作只想拿工资";
        JSONObject res = client.sentimentClassify(text, options);
        System.out.println(res.toString(2));

    }
}
