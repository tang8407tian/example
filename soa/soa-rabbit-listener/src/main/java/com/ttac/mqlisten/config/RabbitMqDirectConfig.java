//package com.ttac.mqlisten.config;
//
//import com.ttac.mqlisten.entity.enums.RabbitMqEnum;
//import org.springframework.amqp.core.*;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
///**
// * description:
// *
// * @author bang.tang
// * @date 2020/8/15--11:29
// */
//@Configuration
//public class RabbitMqDirectConfig {
//    private  String exName = RabbitMqEnum.EXCHANGE_NAME.getDesc();
//    private  String queue_name = RabbitMqEnum.QUEUE_NAME.getDesc();
//    private  String routingKey = RabbitMqEnum.ROUTING_KEY.getDesc();
//
//    /**
//     * 交换机
//     * @return
//     */
//    @Bean
//    public DirectExchange directExchange(){
//        // 一共有三种构造方法，可以只传exchange的名字，
//        // 第二种，可以传exchange名字，是否支持持久化，是否可以自动删除，
//        //第三种在第二种参数上可以增加Map，Map中可以存放自定义exchange中的参数
//        // 采用第二种
//        return new DirectExchange(exName, true, false);
//    }
//
//    /**
//     * 创建消息队列
//     * @return
//     */
//    @Bean
//    public Queue queue(){
//        // // 第一个参数是创建的queue的名字，第二个参数是是否支持持久化
//        return QueueBuilder.durable(queue_name).build();
//    }
//
//    /**
//     * 消息队列于交换机绑定
//     * @return
//     */
//    @Bean
//    public Binding exchangeAndQueueBinding(Queue queue, DirectExchange directExchange){
//        return BindingBuilder.bind(queue).to(directExchange).with(routingKey);
//    }
//}
