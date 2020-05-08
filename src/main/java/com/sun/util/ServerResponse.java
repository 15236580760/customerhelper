package com.sun.util;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.http.HttpStatus;

import java.io.Serializable;

/**
 * 服务器响应内容的实体类
 * 实现Serializable接口的目的是为了保证实体数据可以在网络上传输
 */
public class ServerResponse<T> implements Serializable {
    private int code;  //状态码
    private String msg;  //消息
    private T data;   //数据本身

    private ServerResponse(int code) {
        this.code = code;
    }

    private ServerResponse(int code, T data) {
        this.code = code;
        this.data = data;
    }

    private ServerResponse(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    private ServerResponse(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    //忽略isSuccess不把它序列化
    @JsonIgnore
    public boolean isSuccess() {
        return this.code == HttpStatus.OK.value();
    }

    public int getCode() {
        return code;
    }

    public T getData() {
        return data;
    }

    public String getMsg() {
        return msg;
    }


    public static <T> ServerResponse<T> createBySuccess() {
        return new ServerResponse<>(HttpStatus.OK.value());
    }

    /**
     *
     * @param data
     * @param <T>
     * @return
     */
    public static <T> ServerResponse<T> createBySuccess(T data) {
        return new ServerResponse<>(HttpStatus.OK.value(), data);
    }

    public static <T> ServerResponse<T> createBySuccess(int code,T data) {
        return new ServerResponse<>(code, data);
    }

    public static <T> ServerResponse<T> createBySuccess(String msg, T data) {
        return new ServerResponse<>(HttpStatus.OK.value(), msg, data);
    }

    public static <T> ServerResponse<T> createBySuccessCodeMessages(int code, String msg) {
        return new ServerResponse<>(code, msg);
    }

    public static <T> ServerResponse<T> createBySuccessMessage(String msg) {
        return new ServerResponse<>(HttpStatus.OK.value(), msg);
    }

    //500
    public static <T> ServerResponse<T> createDefaultErrorMessage(String errorMessage) {
        return new ServerResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), errorMessage);
    }

    public static <T> ServerResponse<T> createByErrorCodeMessage(int errorCode, String errorMessage) {
        return new ServerResponse<>(errorCode, errorMessage);
    }
}
