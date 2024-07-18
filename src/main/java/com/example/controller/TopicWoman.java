package com.example.controller;


import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@RabbitListener(queues = "topic.woman")
public class TopicWoman {

  @RabbitHandler
  public void receiverWoman(Map message) {
    System.out.println("woman: " + message);
  }
}
