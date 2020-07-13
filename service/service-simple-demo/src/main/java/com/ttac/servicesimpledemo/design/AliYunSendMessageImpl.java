package com.ttac.servicesimpledemo.design;


import com.ttac.servicesimpledemo.entity.vo.JsonResult;
import lombok.extern.slf4j.Slf4j;

/**
 * 阿里短信
 */
@Slf4j
public class AliYunSendMessageImpl implements SendMessage {
    @Override
    public JsonResult sendMessage(String message) {
        log.info("阿里云发送短信:{}", message);
        return JsonResult.success("阿里云发送短信");
    }
}
