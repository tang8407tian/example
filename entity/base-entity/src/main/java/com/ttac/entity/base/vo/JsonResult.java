package com.ttac.entity.base.vo;/**
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
    @ApiModelProperty("状态码")
    private Integer code = 200;
    @ApiModelProperty("信息")
    private String msg = "success";
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
        this.ts = System.currentTimeMillis();
    }

    public JsonResult(T data) {
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
