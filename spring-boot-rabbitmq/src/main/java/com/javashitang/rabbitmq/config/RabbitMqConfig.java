package com.javashitang.rabbitmq.config;

import com.javashitang.rabbitmq.constants.RabbitMqConsts;
import com.javashitang.rabbitmq.hello.DirectUserReceiver;
import org.springframework.amqp.core.AcknowledgeMode;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfig {

    @Bean
    public ConnectionFactory connectionFactory(
        @Value("${spring.rabbitmq.host}") String host,
        @Value("${spring.rabbitmq.port}") int port,
        @Value("${spring.rabbitmq.username}") String username,
        @Value("${spring.rabbitmq.password}") String password,
        @Value("${spring.rabbitmq.virtual-host}") String vhost) {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory(host, port);
        connectionFactory.setUsername(username);
        connectionFactory.setPassword(password);
        connectionFactory.setVirtualHost(vhost);
        connectionFactory.setPublisherConfirms(true);
        connectionFactory.setPublisherReturns(true);
        return connectionFactory;
    }

    @Bean
    public RabbitAdmin rabbitAdmin(ConnectionFactory connectionFactory) {
        RabbitAdmin admin = new RabbitAdmin(connectionFactory);
        admin.initialize();
        return admin;
    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate template = new RabbitTemplate(connectionFactory);
        template.setMandatory(true);
        template.setConfirmCallback(confirmCallback());
        template.setReturnCallback(returnCallback());
        return template;
    }

    @Bean(RabbitMqConsts.QUEUE_DIRECT_EMAIL)
    public Queue emailQueue() {
        // durable持久队列
        return new Queue(RabbitMqConsts.QUEUE_DIRECT_EMAIL, true);
    }

    @Bean(RabbitMqConsts.QUEUE_DIRECT_USER)
    public Queue userQueue() {
        // durable持久队列
        return new Queue(RabbitMqConsts.QUEUE_DIRECT_USER, true);
    }

    // 消费者确认
    @Bean
    public SimpleMessageListenerContainer listenerContainer(
        ConnectionFactory connectionFactory, @Qualifier(RabbitMqConsts.QUEUE_DIRECT_USER) Queue userQueue,
        DirectUserReceiver userReceiver) {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer(connectionFactory);
        container.setQueues(userQueue);
        container.setAcknowledgeMode(AcknowledgeMode.MANUAL);
        container.setMessageListener(userReceiver);
        return container;
    }

    @Bean
    public RabbitTemplate.ConfirmCallback confirmCallback() {
        return (correlationData, ack ,cause) -> {
            if (ack) {
                System.out.println("发送者确认发送给mq成功");
            } else {
                System.out.println("发送者发送给mq失败，原因为 " + cause);
            }
        };
    }

    @Bean
    public RabbitTemplate.ReturnCallback returnCallback() {
        return (message, replyCode, replyText, exchange, routingKey) -> {
                System.out.println("无法路由的信息，需要重新处理");
                String msg = new String(message.getBody());
                System.out.println(msg);
        };
    }
}
