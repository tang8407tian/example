package com.ttac.entity.base.exception;/**
 * Created by tkmttt on 2019/4/24 15:15.
 */


import com.ttac.entity.base.vo.base.BaseError;

/**
 * @description: 基础业务异常
 * @author: Bao Hongbin
 **/
public class BizBusinessException extends RuntimeException implements BaseError {

    private BaseError baseError;


    public BizBusinessException(BaseError baseError) {
        super(baseError.getErrorMessage());
        this.baseError = baseError;
    }

    public BizBusinessException(BaseError baseError, String errorMessage) {
        super(errorMessage);
        this.baseError = baseError;
        this.baseError.setErrorMessage(errorMessage);
    }

    @Override
    public String getErrorCode() {
        return this.baseError.getErrorCode();
    }

    @Override
    public String getErrorMessage() {
        return this.baseError.getErrorMessage();
    }

    @Override
    public BaseError setErrorMessage(String errorMessage) {
        return this.baseError.setErrorMessage(errorMessage);
    }
}
