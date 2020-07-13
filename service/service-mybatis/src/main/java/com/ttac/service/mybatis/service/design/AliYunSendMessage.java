package com.ttac.service.mybatis.service.design;


import lombok.extern.slf4j.Slf4j;

/**
 * 阿里短信
 */
@Slf4j
public class AliYunSendMessage implements SendMessage {
    @Override
    public void sendMessage(String message) {
        log.info("阿里云发送短信:{}", message);
    }
}
