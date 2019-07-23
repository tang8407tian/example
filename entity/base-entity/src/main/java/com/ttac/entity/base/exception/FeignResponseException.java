package com.ttac.entity.base.exception;

import com.netflix.hystrix.exception.HystrixBadRequestException;
import lombok.Getter;

/**
 * @author vito
 * @version 1.0 2019/7/5
 * 微服务间自定义异常信息传递工具
 * feign 进行熔断降级时会对 HystrixBadRequestException 异常进行过滤，不进行降级操作
 */
@Getter
public class FeignResponseException extends HystrixBadRequestException {
    private String errCode;
    private String errMsg;

    public FeignResponseException(String errCode, String errMsg) {
        super(errMsg);
        this.errCode = errCode;
        this.errMsg = errMsg;
    }
}
