package com.ttac.service.util;
import java.io.Serializable;

/**
 * @description: 公用的Json响应
 * @author: Bao Hongbin
 **/
public class JsonResult<T> implements Serializable {
    /**
     * 200 代表成功
     */
    private final Integer DEFAULT_SUCCESS_CODE = 200;
    private final String DEFAULT_SUCCESS_MSG = "success";

    private Integer code;
    private String message;
    private long responseTime;
    private T data;

    public JsonResult() {
        this.code = DEFAULT_SUCCESS_CODE;
        this.message = DEFAULT_SUCCESS_MSG;
        this.responseTime = System.currentTimeMillis();
    }

    public JsonResult(T data) {
        this.code = DEFAULT_SUCCESS_CODE;
        this.message = DEFAULT_SUCCESS_MSG;
        this.responseTime = System.currentTimeMillis();
        this.data = data;
    }


    public JsonResult(int code, String msg) {
        this.code = code;
        this.message = msg;
        this.responseTime = System.currentTimeMillis();
    }


    public static JsonResult success() {
        return new JsonResult();
    }

    public static JsonResult success(String msg) {
        return new JsonResult(200, msg);
    }

    public static JsonResult success(Object data) {
        return new JsonResult(data);
    }

    public static JsonResult error(int code, String msg) {
        return new JsonResult(code, msg);
    }

    public static JsonResult error(String msg) {
        return new JsonResult(300, msg);
    }

    public static JsonResult error() {
        return new JsonResult(400, "失败");
    }


    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public long getResponseTime() {
        return responseTime;
    }


}
