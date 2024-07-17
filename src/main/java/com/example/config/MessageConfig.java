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
//public class MessageConfig {
//
//  @Autowired
//  CachingConnectionFactory connectionFactory;
//
//  @Autowired
//  private AckReceiver ackReceiver;
//
//  @Bean
//  public SimpleMessageListenerContainer simpleMessageListenerContainer() {
//    SimpleMessageListenerContainer container = new SimpleMessageListenerContainer(connectionFactory);
//    container.setConcurrentConsumers(1);
//    container.setMaxConcurrentConsumers(1);
//    container.setAcknowledgeMode(AcknowledgeMode.MANUAL);
//    container.setQueueNames("DirectQueue", "fanoutQueue1");
//    container.setMessageListener(ackReceiver);
//    return container;
//  }
//}
