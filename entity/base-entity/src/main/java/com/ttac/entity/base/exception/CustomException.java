package com.ttac.entity.base.exception;

/**
 * introduce：自定义异常
 *
 * @date: 2018/10/29
 * @author: bang.tang
 * @time: 10:51
 */
public class CustomException extends RuntimeException implements BaseExceptionType {

    /**
     * 状态码
     */
    private int code;

    /**
     * 描述
     */
    private String description;

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getDescription() {
        return description;
    }

    public CustomException(String message, int code, String description) {
        super(message);
        this.code = code;
        this.description = description;
    }

    public CustomException(BaseExceptionType baseExceptionType) {
        super(baseExceptionType.getDescription());
        this.description = baseExceptionType.getDescription();
        this.code = baseExceptionType.getCode();
    }
}
