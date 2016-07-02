package com.figer.helloworld;
import com.figer.constants.QuenName;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * Created by figer on 6/30/16.
 */
public class Sender {

  public static void main(String[] argv) throws Exception {
    ConnectionFactory factory = new ConnectionFactory();
    factory.setHost("localhost");
    Connection connection = factory.newConnection();
    Channel channel = connection.createChannel();

    channel.queueDeclare(QuenName.HELLO_WORLD.name(), false, false, false, null);
    String message = "Hello World!";
    channel.basicPublish("", QuenName.HELLO_WORLD.name(), null, message.getBytes("UTF-8"));
    System.out.println(" [x] Sent '" + message + "'");

    channel.close();
    connection.close();
  }
}
