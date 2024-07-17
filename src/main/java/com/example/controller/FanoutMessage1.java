//package com.example.controller;
//
//import org.springframework.amqp.rabbit.annotation.RabbitHandler;
//import org.springframework.amqp.rabbit.annotation.RabbitListener;
//import org.springframework.stereotype.Component;
//
//import java.util.Map;
//
//@Component
//@RabbitListener(queues = "fanoutQueue1")
//public class FanoutMessage1 {
//
//  @RabbitHandler
//  public void receiver1(Map message) {
//    System.out.println("1:" + message);
//  }
//
//}
