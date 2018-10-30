package com.ttac.entity.admin.util.enums;

/**
 * introduce：枚举基础接口
 *
 * @date: 2018/9/27
 * @author: bang.tang
 * @time: 11:48
 */
public interface BaseEnum {

    /**
     * 获取枚举数值
     * @return
     */
    int getCode();

    /**
     * 获取枚举描述
     * @return
     */
    String getDescription();
}
