package com.figer.topic.routing;

import com.figer.constants.ExchangeName;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * Created by figer on 7/1/16.
 */
public class TopicPublisher {

  public static void main(String[] args) throws Exception{
    ConnectionFactory connectionFactory = new ConnectionFactory();
    connectionFactory.setHost("localhost");
    Connection connection = connectionFactory.newConnection();
    Channel channel = connection.createChannel();

    channel.exchangeDeclare(ExchangeName.TOPIC_LOGS.name(), "topic");
    String message = "publish [";
    for (int i = 1;i <=10;i++){
      Severity severity = Severity.getRandomSevertiy();
      Facility facility = Facility.getRandomFacility();
      String routingKey = severity.name() + "." + facility.name();
      String indexMessage = message + routingKey + "] message";
      channel.basicPublish(ExchangeName.TOPIC_LOGS.name(), routingKey, null, indexMessage.getBytes());
      System.out.println(" [x] Sent '" + indexMessage + "'");
      Thread.sleep(1000);
    }

    channel.close();
    connection.close();
  }
}
