package com.ttac.entity.base.enums.exception;

import com.ttac.entity.base.exception.BaseExceptionType;
import lombok.Getter;

/**
 * @description: 基础异常类型
 * @author: Bao Hongbin
 */
@Getter
public enum BizExceptionType implements BaseExceptionType {


    //服务器相关错误码
    SERVER_EXCEPTION(1001, "服务器异常"),
    PARAMETER_ERROR(1002, "参数错误"),
    AUTHENTICATION_FAILED(1003, "认证失败"),
    ILLEGAL_OPERATION(1004, "非法操作"),

    // 商品相关错误
    PRODUCT_NOT_EXIST(4200, "商品不存在!"),
    PRODUCT_BASE_ID_NOT_EXIST(4201, "商品id不存在!"),
    PRODUCT_STOCK_WARNING_MIX_GREATER_THAN_MAX(4202, "商品库存预警最小值大于最大值!"),

    // 商品日志
    PRODUCT_LOG_OPERATION_TYPE_NOT_EXIST(4300, "商品日志操作类型为空!"),

    // 活动相关
    PROMOTION_ID_NOT_EXIST(4400, "商品促销活动id为空!"),
    PROMOTION_STEP_ID_NOT_EXIST(4401, "商品促销活动阶梯id为空!"),



    // 通用枚举
    ID_NOT_EXIST(5000, "id为空!"),
    START_TIME_IS_NULL(5001,"开始时间为空!"),
    END_TIME_IS_NULL(5002,"结束时间为空!"),
    PRICE_IS_NULL(5003,"价格为空!"),
    QUANTITY_TIME_IS_NULL(5004,"数量为空!"),
    DATA_NOT_EXIST(5006, "数据为空!"),
    TOKEN_NOT_EXIST(5007, "token为空!"),
    TOKEN_CHECK_FAIL(5008, "token验证失败!"),
    TOKEN_OUT_OF_DATE(5009, "token已过期!"),

    // 组织
    ORG_ID_IS_NULL(6000,"组织id为空!"),
    ORG_IS_NULL(6001,"组织不存在!"),

    //
    PRODUCT_DISTRIBUTOR_LINK_NOT_EXIST(6100,"商品与经销商对应关系未维护"),

    // 活动
    ACTIVITY_TERMINAL_STATISTICS_NOT_EXIST(6200,"活动信息未发现"),
    ACTIVITY_TERMINAL_APPLY_QUANTITY_NOT_REQUIREMENTS(6201,"可兑换数量小于要求兑换数量"),
    ACTIVITY_STEP_NOT_REQUIREMENTS(6202,"兑换阶梯信息不存在"),

    // 验证码 token
    VALIDATE_CODE_IS_EXPIRED(6300, "验证码已过期"),
    VALIDATE_CHECK_IS_ERROR(6301, "验证码错误"),
    ;


    /**
     * 错误码
     */
	private int errorCode;

    /**
     * 错误描述
     */
    private String errorMessage;

    BizExceptionType(int errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    /**
     * 状态码
     *
     * @return
     */
    @Override
    public Integer getCode() {
        return this.errorCode;
    }

    /**
     * 状态描述
     *
     * @return
     */
    @Override
    public String getDescription() {
        return this.errorMessage;
    }
}
