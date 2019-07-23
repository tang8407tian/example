package com.ttac.entity.base.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author vito
 * @version 1.0 2019/7/8
 */
@Getter
@AllArgsConstructor
public enum ErrorHeaderNameEnum {
    ERROR_CODE("errorCode"),
    ERROR_MSG("errorMsg");

    private final String desc;
}
