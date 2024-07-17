//package com.example.controller;
//
//import org.springframework.amqp.rabbit.annotation.RabbitHandler;
//import org.springframework.amqp.rabbit.annotation.RabbitListener;
//import org.springframework.stereotype.Component;
//
//import java.util.Map;
//
//@Component
//@RabbitListener(queues = "fanoutQueue2")
//public class FanoutMessage2 {
//
//  @RabbitHandler
//  public void receiver2(Map message) {
//    System.out.println("2:" + message);
//  }
//
//}
