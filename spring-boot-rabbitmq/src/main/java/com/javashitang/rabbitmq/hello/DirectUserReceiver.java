package com.javashitang.rabbitmq.hello;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.listener.api.ChannelAwareMessageListener;
import org.springframework.stereotype.Component;

@Component
public class DirectUserReceiver implements ChannelAwareMessageListener {

    @Override
    public void onMessage(Message message, Channel channel) throws Exception {
        try {
            String msg = new String(message.getBody());
            System.out.println("DirectUserReceiver 收到消息 " + msg);
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
            System.out.println("消息已消费");
        } catch (Exception e) {
            channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, true);
            System.out.println("拒绝消息，mq重新派发");
        }
    }
}
