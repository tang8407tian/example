/**
 *
 */
package com.ttac.service.myabtis.config.exception;


import com.ttac.entity.base.enums.ErrorHeaderNameEnum;
import com.ttac.entity.base.enums.exception.BizExceptionType;
import com.ttac.entity.base.exception.CustomException;
import com.ttac.entity.base.exception.FeignResponseException;
import com.ttac.service.myabtis.vo.JsonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;


/**
 * @description: 全局异常处理
 * @author: Bao Hongbin
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

	@ExceptionHandler(Exception.class)
	public Object handleBizBusinessException(Exception ex, HttpServletResponse response) throws UnsupportedEncodingException{
		log.error("异常信息:{}", ex.toString());
		StackTraceElement[] stackTrace = ex.getStackTrace();
		for (StackTraceElement traceElement : stackTrace) {
			log.error("             at:{}",traceElement);
		}
		response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		response.setContentType("application/json;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		if (ex instanceof CustomException) {
			Integer code = ((CustomException) ex).getCode();
			response.addHeader(ErrorHeaderNameEnum.ERROR_CODE.getDesc(), URLEncoder.encode(code.toString(), StandardCharsets.UTF_8.name()));
			String desc = ((CustomException) ex).getDescription();
			response.addHeader(ErrorHeaderNameEnum.ERROR_MSG.getDesc(), URLEncoder.encode(desc, StandardCharsets.UTF_8.name()));
			log.info("BizBusinessException.code={},msg={}",code, desc, ex);
			return response;
		} else if (ex instanceof FeignResponseException) {
			String code = ((FeignResponseException) ex).getErrCode();
			response.addHeader(ErrorHeaderNameEnum.ERROR_CODE.getDesc(), URLEncoder.encode(code, StandardCharsets.UTF_8.name()));
			String desc = ((FeignResponseException) ex).getErrMsg();
			response.addHeader(ErrorHeaderNameEnum.ERROR_MSG.getDesc(), URLEncoder.encode(desc, StandardCharsets.UTF_8.name()));
			log.info("FeignResponseException.code={},msg={}",code, desc, ex);
			return response;
		}else {
				String message = ex.getMessage();
				log.error("unprocessed exceptions.", ex.toString());
//				response.addHeader(ErrorHeaderNameEnum.ERROR_CODE.getDesc(), "5067");
//				response.addHeader(ErrorHeaderNameEnum.ERROR_MSG.getDesc(), message);
				return response;
			}
	}


	@ExceptionHandler(Throwable.class)
	@ResponseBody
	public JsonResult handleThrowable(Throwable throwable) {
		StackTraceElement[] trace = throwable.getStackTrace();
		for (StackTraceElement traceElement : trace){
			log.error("\tat " + traceElement);
		}
		String message = throwable.getMessage();
		return new JsonResult(4001,message);
	}

}
