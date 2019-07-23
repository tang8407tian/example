package com.ttac.entity.base.exception;

/**
 * introduce：自定义异常顶层接口
 *
 * @date: 2018/10/29
 * @author: bang.tang
 * @time: 10:44
 */
public interface BaseExceptionType {

    /**
     * 状态码
     * @return
     */
    Integer getCode();

    /**
     * 状态描述
     * @return
     */
    String getDescription();
}
