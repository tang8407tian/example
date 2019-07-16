package com.ttac.entity.admin.vo.request.login;

import com.ttac.entity.admin.util.enums.login.LoginTypeEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * description: 登录vo
 *
 * @author bang.tang
 * @date 2019/7/16--14:49
 */
@Data
@ApiModel(value = "登录",description = "登录vo")
public class LoginRequestVO implements Serializable {

    private static final long serialVersionUID = -3967873324312135362L;


    @ApiModelProperty(value = "登录账号")
    private String accountNumber;

    @ApiModelProperty("密码")
    private String password;

    @ApiModelProperty("验证码")
    private String verificationCode;

    @ApiModelProperty("登录方式:ACCOUNT_PASSWORD(0,\"账号密码登录\")、TELEPHONE_CODE(5,\"短信验证码登录\")")
    private LoginTypeEnum loginType;

}
