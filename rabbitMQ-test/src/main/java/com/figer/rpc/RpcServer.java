package com.figer.rpc;

import com.figer.constants.QuenName;
import com.rabbitmq.client.AMQP.BasicProperties;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.QueueingConsumer;

/**
 * Created by figer on 7/2/16.
 */
public class RpcServer {

  public static void main(String[] args) throws Exception{
    Connection connection = null;
    Channel channel = null;
    try {
      ConnectionFactory factory = new ConnectionFactory();
      factory.setHost("localhost");
      connection = factory.newConnection();
      channel = connection.createChannel();

      channel.queueDeclare(QuenName.RPC_REQUEST.name(), false, false, false, null);
      channel.basicQos(2);

      QueueingConsumer consumer = new QueueingConsumer(channel);
      channel.basicConsume(QuenName.RPC_REQUEST.name(), false, consumer);

      System.out.println(" [x] Awaiting RPC requests");

      while (true){
        String response = null;
        QueueingConsumer.Delivery delivery = consumer.nextDelivery();

        BasicProperties requestProps = delivery.getProperties();
        BasicProperties replyProps = new BasicProperties.Builder()
            .correlationId(requestProps.getCorrelationId())
            .build();

        try {
          String message = new String(delivery.getBody(), "UTF-8");
          int n = Integer.parseInt(message);
          System.out.println(" [.] fib(" + message + ")");
          response = "" + fibonacci(n);
        }catch (Exception e){
          System.out.println(" [.] " + e.toString());
          response = "";
        }finally {
          System.out.println("--------requestProps.replyTo:" + requestProps.getReplyTo());
          channel.basicPublish("", requestProps.getReplyTo(), replyProps, response.getBytes("UTF-8"));
          channel.basicAck(delivery.getEnvelope().getDeliveryTag(), false);
        }
      }
    }catch (Exception e){
      e.printStackTrace();
    }finally {
      if (connection != null) {
        try {
          connection.close();
        }
        catch (Exception ignore) {}
      }
    }

  }


  /**
   *  Just for test,it's probably the slowest recursive implementation possible
   * @param index
   * @return
   */
  private static int fibonacci(int index){
    if(index == 1 || index == 2){
      return 1;
    }

    return fibonacci(index - 1) + fibonacci(index - 2);
  }
}
