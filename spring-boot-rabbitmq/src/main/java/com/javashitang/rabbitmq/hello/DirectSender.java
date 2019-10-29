package com.javashitang.rabbitmq.hello;

import com.javashitang.rabbitmq.constants.RabbitMqConsts;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DirectSender {

    @Autowired
    RabbitTemplate rabbitTemplate;

    public void send(String msg) {
        rabbitTemplate.convertAndSend(RabbitMqConsts.QUEUE_DIRECT_EMAIL, msg);
        rabbitTemplate.convertAndSend(RabbitMqConsts.QUEUE_DIRECT_USER, msg);
    }
}
