package com.figer.routing;

import java.io.IOException;
import java.util.Arrays;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;

/**
 * Created by figer on 7/1/16.
 */
public class DirectSubscriberFactory {
  private static final String EXCHANGE_NAME = "direct_logs";

  public void runDirectSubscriber(Severity[] severityArray) throws Exception{
    System.out.println("create a " + Arrays.toString(severityArray) + " direct subscriber and run it...");
    ConnectionFactory factory = new ConnectionFactory();
    factory.setHost("localhost");
    Connection connection = factory.newConnection();
    Channel channel = connection.createChannel();

    channel.exchangeDeclare(EXCHANGE_NAME, "direct");
    //create a non-durable, exclusive, autodelete queue with a generated name
    String queueName = channel.queueDeclare().getQueue();
    for(Severity severity : severityArray){
      channel.queueBind(queueName, EXCHANGE_NAME, severity.name());
    }

    System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

    Consumer consumer = new DefaultConsumer(channel){
      @Override
      public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
        String message = new String(body, "UTF-8");
        System.out.println(" [x] Received '" + message + "'");
      }
    };

    channel.basicConsume(queueName, true, consumer);
  }
}
