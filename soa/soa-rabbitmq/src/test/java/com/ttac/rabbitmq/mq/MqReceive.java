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
 * description: 接收消息
 *
 * @author bang.tang
 * @date 2020/8/15--11:50
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class MqReceive {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    public void sendTest(){

        rabbitTemplate.convertAndSend(RabbitMqEnum.EXCHANGE_NAME.getDesc(), RabbitMqEnum.ROUTING_KEY.getDesc(),"发送rabbit mq 消息1111!");
        rabbitTemplate.convertAndSend(RabbitMqEnum.EXCHANGE_NAME.getDesc(), RabbitMqEnum.ROUTING_KEY.getDesc(),"发送rabbit mq 消息2222!");
        rabbitTemplate.convertAndSend(RabbitMqEnum.EXCHANGE_NAME.getDesc(), RabbitMqEnum.ROUTING_KEY.getDesc(),"发送rabbit mq 消息3333!");

    }


}
