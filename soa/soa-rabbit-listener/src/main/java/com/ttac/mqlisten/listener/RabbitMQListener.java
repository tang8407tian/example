package com.ttac.mqlisten.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;


/**
 * description:
 *
 * @author bang.tang
 * @date 2020/8/15--13:29
 */
@Component
@Slf4j
public class RabbitMQListener {


    /**
     * 使用 @RabbitListener 注解标记方法，当监听到队列 debug 中有消息时则会进行接收并处理
     * 消息处理方法参数是由 MessageConverter 转化，若使用自定义 MessageConverter 则需要在 RabbitListenerContainerFactory 实例中去设置（默认 Spring 使用的实现是 SimpleRabbitListenerContainerFactory）
     *
     * 消息的 content_type 属性表示消息 body 数据以什么数据格式存储，接收消息除了使用 Message 对象接收消息（包含消息属性等信息）之外，还可直接使用对应类型接收消息 body 内容，但若方法参数类型不正确会抛异常
     * @param message
     */
    @RabbitListener(queues = {"ttac.top.queue"})
    public void listener(Message message){

        try {
            log.info("接收到消息队列消息为:{}",message);
        } catch (Exception e) {
//            e.printStackTrace();
            log.error("rabbitmq接收消息错误:{}",e);
        }

    }
}
