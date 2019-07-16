package com.ttac.entity.admin.enums;

import com.ttac.entity.admin.util.enums.BaseConvertEnum;
import com.ttac.entity.admin.util.enums.BaseEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * introduce：通用枚举
 *
 * @date: 2018/10/22
 * @author: bang.tang
 * @time: 15:24
 */
@Getter
@AllArgsConstructor
public enum CommonEnum implements BaseEnum{

    /**
     * 代表否一类信息
     */
    DISABLE(0, "禁用"),
    /**
     * 代表是一类信息
     */
    ENABLE(1, "启用");


    /**
     * 信息
     */
    private int code;

    /**
     * 描述
     */
    private String description;

    @Override
    public Integer getCode() {
        return code;
    }

    @Override
    public String getDescription() {
        return description;
    }

    /**
     * jpa 保存数据库  用于信息与枚举之间转换
     */
    public static class Convert extends BaseConvertEnum<CommonEnum> {

    }
}
