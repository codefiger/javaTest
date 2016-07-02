package com.figer.rpc;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.QueueingConsumer;

import java.util.UUID;

/**
 * Created by figer on 7/2/16.
 */
public class RpcClient {
  private Connection connection;
  private Channel channel;
  private String requestQueueName = "rpc_queue";
  private String replyQueueName;
  private QueueingConsumer respConsumer;

  public RpcClient() throws Exception {
    ConnectionFactory factory = new ConnectionFactory();
    factory.setHost("localhost");
    connection = factory.newConnection();
    channel = connection.createChannel();

    replyQueueName = channel.queueDeclare().getQueue();
    respConsumer = new QueueingConsumer(channel);
    channel.basicConsume(replyQueueName, true, respConsumer);
  }

  public String call(String message) throws Exception {
    String response = null;
    String corrId = UUID.randomUUID().toString();

    AMQP.BasicProperties props = new AMQP.BasicProperties
        .Builder()
        .correlationId(corrId)
        .replyTo(replyQueueName)
        .build();

    channel.basicPublish("", requestQueueName, props, message.getBytes("UTF-8"));

    while (true) {
      QueueingConsumer.Delivery delivery = respConsumer.nextDelivery();
      if (delivery.getProperties().getCorrelationId().equals(corrId)) {
        response = new String(delivery.getBody(),"UTF-8");
        break;
      }
    }

    return response;
  }

  public void close() throws Exception {
    connection.close();
  }

  public static void main(String[] argv) {
    RpcClient fibonacciRpc = null;
    String response = null;
    try {
      fibonacciRpc = new RpcClient();

      System.out.println(" [x] Requesting fib(30)");
      response = fibonacciRpc.call("30");
      System.out.println(" [.] Got '" + response + "'");
    }
    catch  (Exception e) {
      e.printStackTrace();
    }
    finally {
      if (fibonacciRpc!= null) {
        try {
          fibonacciRpc.close();
        }
        catch (Exception ignore) {}
      }
    }
  }
}
