//package com.example.controller;
//
//import org.springframework.amqp.rabbit.annotation.RabbitHandler;
//import org.springframework.amqp.rabbit.annotation.RabbitListener;
//import org.springframework.stereotype.Component;
//
//import java.util.Map;
//
//@Component
//@RabbitListener(queues = "DirectQueue")
//public class DirectMessage {
//
//  @RabbitHandler
//  public void receiverDirect(Map message) {
//    System.out.println(message);
//  }
//
//}
