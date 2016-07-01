package com.figer.workqueue;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;

/**
 * Created by figer on 6/30/16.
 */
public class WorkQueueSender {
  private static final String TASK_QUEUE_NAME = "task_queue";

  public static void main(String[] argv) throws Exception {
    ConnectionFactory factory = new ConnectionFactory();
    factory.setHost("localhost");
    Connection connection = factory.newConnection();
    Channel channel = connection.createChannel();

    channel.queueDeclare(TASK_QUEUE_NAME, true, false, false, null);

    String message = getMessage(argv);

    for(int i = 0; i < 10;i ++){
      String indexMessage;
      indexMessage = i + message;
      channel.basicPublish("", TASK_QUEUE_NAME,
          MessageProperties.PERSISTENT_TEXT_PLAIN,
          indexMessage.getBytes("UTF-8"));
      System.out.println(" [x] Sent '" + indexMessage + "'");
    }


    channel.close();
    connection.close();
  }

  private static String getMessage(String[] strings) {
    if (strings.length < 1)
      return "Hello World!";
    return joinStrings(strings, " ");
  }

  private static String joinStrings(String[] strings, String delimiter) {
    int length = strings.length;
    if (length == 0) return "";
    StringBuilder words = new StringBuilder(strings[0]);
    for (int i = 1; i < length; i++) {
      words.append(delimiter).append(strings[i]);
    }
    return words.toString();
  }
}
