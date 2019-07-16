package com.ttac.entity.admin.util.enums.login;

import com.ttac.entity.admin.util.enums.BaseEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * description: 登录方式
 *
 * @author bang.tang
 * @date 2019/7/16--14:54
 */
@Getter
@AllArgsConstructor
public enum  LoginTypeEnum implements BaseEnum {
    ACCOUNT_PASSWORD(0,"账号密码登录"),

    TELEPHONE_CODE(5,"短信验证码登录"),

    ;
    private Integer code;

    private String description;
}
