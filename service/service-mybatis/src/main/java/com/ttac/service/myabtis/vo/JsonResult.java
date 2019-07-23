package com.ttac.service.myabtis.vo;/**
 * Created by tkmttt on 2019/4/24 14:42.
 */


import com.ttac.entity.base.exception.BaseExceptionType;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @description: 公用的Json响应
 * @author: Bao Hongbin
 **/
@Data
public class JsonResult<T> implements Serializable {
    /**
     * 200 代表成功
     */
    private final Integer DEFAULT_SUCCESS_CODE = 200;
    private final String DEFAULT_SUCCESS_MSG = "success";
    @ApiModelProperty("状态码")
    private Integer code;
    @ApiModelProperty("信息")
    private String msg;
    @ApiModelProperty("时间戳")
    private long ts;
    @ApiModelProperty("返回内容")
    private T data;

    /**
     * 授权token
     */
    @ApiModelProperty("授权token")
    private String access_token;

    public JsonResult() {
        this.code = DEFAULT_SUCCESS_CODE;
        this.msg = DEFAULT_SUCCESS_MSG;
        this.ts = System.currentTimeMillis();
    }

    public JsonResult(T data) {
        this.code = DEFAULT_SUCCESS_CODE;
        this.msg = DEFAULT_SUCCESS_MSG;
        this.ts = System.currentTimeMillis();
        this.data = data;
    }


    public JsonResult(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
        this.ts = System.currentTimeMillis();
    }

    public JsonResult(BaseExceptionType baseError) {
        this(baseError.getCode(), baseError.getDescription());
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

    public static JsonResult error(Integer code, String msg) {
        return new JsonResult(code, msg);
    }

    public static JsonResult error(String msg) {
        return new JsonResult(4001, msg);
    }

    public static JsonResult error() {
        return new JsonResult(4001, "失败");
    }

    public static JsonResult error(BaseExceptionType baseError) {
        return new JsonResult(baseError);
    }


}
