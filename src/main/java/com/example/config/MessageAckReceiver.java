package com.example.config;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.listener.api.ChannelAwareMessageListener;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import java.util.Map;

@Component
public class MessageAckReceiver implements ChannelAwareMessageListener {
  @Override
  public void onMessage(Message message, Channel channel) throws Exception {
    long deliverTag = message.getMessageProperties().getDeliveryTag();
    try {
      byte[] body = message.getBody();
      Map<String, Object> map = deserialize(body);
      System.out.println("messageId: " + map.get("messageId") + "\nmessageData: " + map.get("messageData") + "\nmessageTime: " + map.get("messageTime"));
      System.out.println("消息来自队列: " + message.getMessageProperties().getConsumerQueue());
      System.out.println(message.getMessageProperties().getDeliveryTag());
      System.out.println("2");
      channel.basicAck(deliverTag, true);
    } catch (Exception e) {
      e.printStackTrace();
      channel.basicReject(deliverTag, false);
    }
  }

  private Map<String, Object> deserialize(byte[] data) {
    try (ByteArrayInputStream bio = new ByteArrayInputStream(data);
         ObjectInputStream ois = new ObjectInputStream(bio)) {
      return (Map<String, Object>) ois.readObject();
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }
}
