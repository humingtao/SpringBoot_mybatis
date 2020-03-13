package com.example.SpringBoot_mybatis.util;

import lombok.Data;

import java.util.Collections;
import java.util.List;

@Data
public class MyPage<T> {
    private Integer code = 200;// 状态码，默认状态

    private String message = "";// 提示消息或者错误消息

    private String apiId = "";// 请求的唯一标识，预留

    private Integer totalCount = 0;//记录总数

    private List<T> rows = Collections.emptyList();//本次返回的数据列表

}
