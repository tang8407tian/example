package com.ttac.servicesimpledemo.design;

import com.ttac.servicesimpledemo.entity.vo.JsonResult;
import lombok.extern.slf4j.Slf4j;

/**
 * 青云短信发送
 */
@Slf4j
public class QinYunSendMessageImpl implements SendMessage{

    @Override
    public JsonResult sendMessage(String message) {
        log.info("青云短信发送:{}", message);
        return JsonResult.success("青云短信发送");
    }
}
