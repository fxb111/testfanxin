//package com.example.controller;
//
//import org.springframework.amqp.rabbit.annotation.RabbitHandler;
//import org.springframework.amqp.rabbit.annotation.RabbitListener;
//import org.springframework.stereotype.Component;
//
//import java.util.Map;
//
//@Component
//@RabbitListener(queues = "fanoutQueue3")
//public class FanoutMessage3 {
//
//  @RabbitHandler
//  public void receiver3(Map message) {
//    System.out.println("3:" + message);
//  }
//
//}
