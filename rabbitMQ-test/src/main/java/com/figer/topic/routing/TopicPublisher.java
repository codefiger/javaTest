package com.figer.topic.routing;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * Created by figer on 7/1/16.
 */
public class TopicPublisher {
  private static final String EXCHANGE_NAME = "topic_logs";

  public static void main(String[] args) throws Exception{
    ConnectionFactory connectionFactory = new ConnectionFactory();
    connectionFactory.setHost("localhost");
    Connection connection = connectionFactory.newConnection();
    Channel channel = connection.createChannel();

    channel.exchangeDeclare(EXCHANGE_NAME, "topic");
    String message = "publish [";
    for (int i = 1;i <=10;i++){
      Severity severity = Severity.getRandomSevertiy();
      Facility facility = Facility.getRandomFacility();
      String routingKey = severity.name() + "." + facility.name();
      String indexMessage = message + routingKey + "] message";
      channel.basicPublish(EXCHANGE_NAME, routingKey, null, indexMessage.getBytes());
      System.out.println(" [x] Sent '" + indexMessage + "'");
      Thread.sleep(1000);
    }

    channel.close();
    connection.close();
  }
}
