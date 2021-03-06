package com.figer.helloworld;

import com.figer.constants.QuenName;
import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;

import java.io.IOException;

/**
 * Created by figer on 6/30/16.
 */
public class Receiver {

  public static void main(String[] argv) throws Exception {
    ConnectionFactory factory = new ConnectionFactory();
    factory.setHost("localhost");
    Connection connection = factory.newConnection();
    Channel channel = connection.createChannel();

    //we declare the queue here. Because we might start the receiver before the sender
    channel.queueDeclare(QuenName.HELLO_WORLD.name(), false, false, false, null);
    System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

    Consumer consumer = new DefaultConsumer(channel) {
      @Override
      public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body)
          throws IOException {
        try {
          Thread.sleep(10000);
        }catch (Exception e){
          // do nothing
        }
        String message = new String(body, "UTF-8");
        System.out.println(" [x] Received '" + message + "'");
      }
    };
    channel.basicConsume(QuenName.HELLO_WORLD.name(), true, consumer);
    System.out.println("-----");
    channel.basicConsume(QuenName.HELLO_WORLD.name(), true, consumer);
    System.out.println("-----");
  }
}
