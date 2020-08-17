package com.ttac.rabbitmq.mq;

import com.ttac.rabbitmq.entity.enums.RabbitMqEnum;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * description: 发送消息
 *
 * @author bang.tang
 * @date 2020/8/15--11:49
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class MqSend {


    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    public void sendTest(){
        Integer f = 10;
        for (Integer i = 0; i < f; i++) {
            rabbitTemplate.convertAndSend(RabbitMqEnum.EXCHANGE_NAME.getDesc(), RabbitMqEnum.ROUTING_KEY.getDesc(),"发送rabbit mq 消息【"+i+"】");
        }
//        rabbitTemplate.convertAndSend(RabbitMqEnum.EXCHANGE_NAME.getDesc(), RabbitMqEnum.ROUTING_KEY.getDesc(),"发送rabbit mq 消息2222!");
//        rabbitTemplate.convertAndSend(RabbitMqEnum.EXCHANGE_NAME.getDesc(), RabbitMqEnum.ROUTING_KEY.getDesc(),"发送rabbit mq 消息3333!");
//        rabbitTemplate.convertAndSend(RabbitMqEnum.EXCHANGE_NAME.getDesc(), RabbitMqEnum.ROUTING_KEY.getDesc(),"发送rabbit mq 消息dewweewe!");
//        rabbitTemplate.convertAndSend(RabbitMqEnum.EXCHANGE_NAME.getDesc(), RabbitMqEnum.ROUTING_KEY.getDesc(),"发送rabbit mq ssssssssssssss!");
//        rabbitTemplate.convertAndSend(RabbitMqEnum.EXCHANGE_NAME.getDesc(), RabbitMqEnum.ROUTING_KEY.getDesc(),"发送rabbit mq rrrrrrrrrrr!");

    }
}
