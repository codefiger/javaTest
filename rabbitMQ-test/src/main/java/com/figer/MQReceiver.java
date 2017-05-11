package com.figer;

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
public class MQReceiver {

  public static void main(String[] argv) throws Exception {
    ConnectionFactory factory = new ConnectionFactory();
    factory.setHost("10.18.19.64");
    factory.setPort(5672);
    factory.setUsername("admin");
    factory.setPassword("dangerous");
    factory.setVirtualHost("/msgbus");
    factory.setAutomaticRecoveryEnabled(true);
    Connection connection = factory.newConnection();
    Channel channel = connection.createChannel();
    channel.exchangeDeclare("coffee.crm.exch.sync", "topic", true);
    String queueName = channel.queueDeclare().getQueue();
    channel.queueBind(queueName,"coffee.crm.exch.sync", "coffee.crm.sync.actor");

    //we declare the queue here. Because we might start the receiver before the sender
    System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

    Consumer consumer = new DefaultConsumer(channel) {
      @Override
      public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body)
          throws IOException {
        String message = new String(body, "UTF-8");
        System.out.println(" [x] Received '" + message + "'");
      }
    };

    channel.basicConsume(queueName, true, consumer);
    System.out.println("-----");
  }
}
