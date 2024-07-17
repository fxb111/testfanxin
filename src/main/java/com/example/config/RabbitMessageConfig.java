package com.example.config;

import org.springframework.amqp.core.AcknowledgeMode;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMessageConfig {

  @Autowired
  CachingConnectionFactory connectionFactory;

  @Autowired
  public MessageAckReceiver messageAckReceiver;

  @Bean
  public SimpleMessageListenerContainer simpleMessageListenerContainer() {
    SimpleMessageListenerContainer container = new SimpleMessageListenerContainer(connectionFactory);
    container.setAcknowledgeMode(AcknowledgeMode.MANUAL);
    container.setConcurrentConsumers(1);
    container.setMaxConcurrentConsumers(1);
    container.setQueueNames("DirectQueue", "fanoutQueue1");
    container.setMessageListener(messageAckReceiver);
    return container;
  }
}
