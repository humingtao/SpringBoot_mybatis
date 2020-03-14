package com.example.SpringBoot_mybatis.entity;

import com.example.SpringBoot_mybatis.enmu.ResultCode;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.io.Serializable;

@Data
public class Result<T> implements Serializable {
    private static final long serialVersionUID = 9211889136173018364L;

    /**
     * 正常响应码
     */
    private static final int SUCCESS_CODE = 200;

    /**
     * 正常响应消息
     */
    private static final String SUCCESS_MSG = "SUCCESS";

    /**
     * 错误码
     */
    private int code = SUCCESS_CODE;

    /**
     * 错误信息
     */
    private String msg = SUCCESS_MSG;

    /**
     * 响应内容，默认为null
     */
    private T data = null;

    /**
     * 是否的正常响应
     *
     * @return true=正常；false=异常
     */
    @JsonIgnore
    public boolean isOK() {
        return code == SUCCESS_CODE;
    }

    /**
     * 无data的正常返回
     */
    public static Result retOK() {
        return new Result();
    }

    /**
     * 有data的正常返回
     *
     * @param data data内容
     * @param <T> data类型
     */
    public static <T> Result<T> retOK(T data) {
        Result<T> response = new Result<>();
        response.setData(data);
        return response;
    }

    /**
     * 无data的失败返回
     *
     * @param error 错误类型
     */
    public static Result retFail(ResultCode error) {
        return retFail(error.getCode(), error.getMessage());
    }

    /**
     * 有data的失败返回
     *
     * @param error 错误类型
     * @param data 详细错误信息
     */
    public static <T> Result<T> retFail(ResultCode error, T data) {
        return retFail(error.getCode(), error.getMessage(), data);
    }

    /**
     * 无data的失败返回
     *
     * @param code 错误码
     * @param msg 错误信息
     */
    public static <T> Result<T> retFail(int code, String msg) {
        Result<T> response = new Result<>();
        response.setCode(code);
        response.setMsg(msg);
        return response;
    }

    /**
     * 有data的失败返回
     * <br>
     * 失败返回的场景不多，所以没有严格要求T泛型
     *
     * @param code 错误码
     * @param msg 错误信息
     */
    public static <T> Result<T> retFail(int code, String msg, T data) {
        Result<T> response = new Result<>();
        response.setCode(code);
        response.setMsg(msg);
        response.setData(data);
        return response;
    }
}
