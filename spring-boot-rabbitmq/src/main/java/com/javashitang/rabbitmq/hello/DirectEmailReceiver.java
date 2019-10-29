package com.javashitang.rabbitmq.hello;

import com.javashitang.rabbitmq.constants.RabbitMqConsts;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = RabbitMqConsts.QUEUE_DIRECT_EMAIL)
public class DirectEmailReceiver {

    @RabbitHandler
    public void process(String msg) {
        System.out.println("DirectEmailReceiver 收到消息 " + msg);
    }
}
