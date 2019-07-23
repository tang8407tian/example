package com.ttac.entity.base.vo.base;

/**
 * @description: 基础错误
 * @author: Bao Hongbin
 */
public interface BaseError {


    /**
     * 获取错误编码
     * @return 错误编码
     */
    String getErrorCode();

    /**
     * 获取错误信息
     * @return 错误信息
     */
    String getErrorMessage();

    /**
     * 设置错误信息
     * @param errorMessage 错误信息
     * @return 错误信息
     */
    BaseError setErrorMessage(String errorMessage);
}
