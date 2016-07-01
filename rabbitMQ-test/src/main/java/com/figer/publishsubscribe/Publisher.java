package com.figer.publishsubscribe;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * Created by figer on 7/1/16.
 */
public class Publisher {
  private static final String EXCHANGE_NAME = "logs";

  public static void main(String[] args) throws Exception{
    ConnectionFactory connectionFactory = new ConnectionFactory();
    connectionFactory.setHost("localhost");
    Connection connection = connectionFactory.newConnection();
    Channel channel = connection.createChannel();

    channel.exchangeDeclare(EXCHANGE_NAME, "fanout");
    String message = "publish ";
    for (int i = 1;i <=10;i++){
      String indexMessage = message + i + " message";
      channel.basicPublish(EXCHANGE_NAME, "", null, indexMessage.getBytes());
      System.out.println(" [x] Sent '" + indexMessage + "'");
      Thread.sleep(1000);
    }

    channel.close();
    connection.close();
  }
}
