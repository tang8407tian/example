package com.ttac.servicesimpledemo.controller;

import com.ttac.servicesimpledemo.design.AliYunSendMessageImpl;
import com.ttac.servicesimpledemo.design.QinYunSendMessageImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class LoginControllerTest {

    @Autowired
    private LoginController loginController;


    @Test
    public void sendTest(){
        AliYunSendMessageImpl aliYunSendMessage = new AliYunSendMessageImpl();
        QinYunSendMessageImpl qinYunSendMessage = new QinYunSendMessageImpl();
        loginController.addSendList(aliYunSendMessage);
        loginController.addSendList(qinYunSendMessage);
        loginController.sendMessage("发送短信测试");
    }
}
