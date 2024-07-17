//package com.example.config;
//
//import org.springframework.amqp.core.AcknowledgeMode;
//import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
//import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class MessageListenerConfig {
//
//  @Autowired
//  CachingConnectionFactory connectionFactory;
//
//  @Autowired
//  private MyAckReceiver myAckReceiver;
//
//  @Bean
//  public SimpleMessageListenerContainer simpleMessageListenerContainer() {
//    SimpleMessageListenerContainer simpleMessageListenerContainer = new SimpleMessageListenerContainer(connectionFactory);
//    simpleMessageListenerContainer.setConcurrentConsumers(1);
//    simpleMessageListenerContainer.setMaxConcurrentConsumers(1);
//    simpleMessageListenerContainer.setAcknowledgeMode(AcknowledgeMode.MANUAL);
//    simpleMessageListenerContainer.setQueueNames("DirectQueue", "fanoutQueue1");
//    simpleMessageListenerContainer.setMessageListener(myAckReceiver);
//    return simpleMessageListenerContainer;
//  }
//
//}
