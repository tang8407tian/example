package com.ttac.entity.admin.exception.enums;

import com.ttac.entity.base.exception.BaseExceptionType;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * introduce：枚举转换相关异常
 *
 * @date: 2018/10/29
 * @author: bang.tang
 * @time: 10:43
 */
@Getter
@AllArgsConstructor
public enum EnumException implements BaseExceptionType {

    GET_CODE_ERROR(1001, "枚举获取状态码失败!");

    int code;

    String description;

}
