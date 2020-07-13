package com.ttac.servicesimpledemo.controller;

import com.ttac.servicesimpledemo.design.SendMessage;
import com.ttac.servicesimpledemo.entity.vo.JsonResult;
import com.ttac.servicesimpledemo.util.DateFormatUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Controller
@Slf4j
public class LoginController {


    List<SendMessage> sendMessageList = new ArrayList<>();

    public void addSendList(SendMessage sendMessage){
        sendMessageList.add(sendMessage);
    }

    public void sendMessage(String message){
        for (SendMessage sendMessage : sendMessageList) {
            log.info("发送开始时间：{}", DateFormatUtils.dataTime(LocalDateTime.now()));
            JsonResult jsonResult = sendMessage.sendMessage(message);
            if (Objects.equals(jsonResult.getCode(), 200)){
                log.info("[{}]--成功", jsonResult.getMsg());
                log.info("发送结束时间：{}", DateFormatUtils.dataTime(LocalDateTime.now()));
                break;
            }
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.info("[{}]--发送失败尝试下一个短信发送", jsonResult.getMsg());
        }

        // lambda表达式处理集合时，发现对return、break以及continue的使用\
        // 在使用foreach()处理集合时不能使用break和continue这两个方法，
        // return，这个只能跳过本次循环，还是会继续执行for循环的。
        // Stack Overflow中找到一个答案，主要是说foreach()不是一个循环，不是设计为可以用break以及continue来中止的操作。
//        sendMessageList.forEach(c->{
//            JsonResult jsonResult = c.sendMessage(message);
//            if (Objects.equals(jsonResult.getCode(), 200)){
//                break;
//            }
//            if (Objects.equals(jsonResult.getCode(), 200)){
//                continue;
//            }
//            if (Objects.equals(jsonResult.getCode(), 200)){
//                return;
//            }
//
//        });
    }
}
