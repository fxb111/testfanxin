//package com.example.config;
//
//import com.rabbitmq.client.Channel;
//import org.springframework.amqp.core.Message;
//import org.springframework.amqp.rabbit.listener.api.ChannelAwareMessageListener;
//import org.springframework.stereotype.Component;
//
//import java.io.ByteArrayInputStream;
//import java.io.ObjectInputStream;
//import java.util.HashMap;
//import java.util.Map;
//
//@Component
//public class MyAckReceiver implements ChannelAwareMessageListener {
//  @Override
//  public void onMessage(Message message, Channel channel) throws Exception {
//    long deliverTag = message.getMessageProperties().getDeliveryTag();
//    try {
//      byte[] body = message.getBody();
//      Map<String, Object> msgMap = deserialize(body);
//      System.out.println("messageId: " + msgMap.get("messageId") + "\nmessageData: " + msgMap.get("messageData") + "\nmessageTime: " + msgMap.get("messageTime"));
//      System.out.println("消费的主题队列来自" + message.getMessageProperties().getConsumerQueue());
//      channel.basicAck(deliverTag, true);
//    } catch (Exception e) {
//      channel.basicReject(deliverTag, false);
//      e.printStackTrace();
//    }
//  }
//
//  private Map<String, Object> deserialize(byte[] data) {
//    try (ByteArrayInputStream bis = new ByteArrayInputStream(data);
//         ObjectInputStream ois = new ObjectInputStream(bis)) {
//      return (HashMap<String, Object>) ois.readObject();
//    } catch (Exception e) {
//      e.printStackTrace();
//      return null;
//    }
//  }
//}
