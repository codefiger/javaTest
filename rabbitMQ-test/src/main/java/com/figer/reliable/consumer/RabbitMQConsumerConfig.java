package com.figer.reliable.consumer;

import com.rabbitmq.client.Channel;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.amqp.core.AcknowledgeMode;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.ChannelAwareMessageListener;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Scope;
import org.springframework.transaction.TransactionException;

import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by figer on 24/07/2017.
 */
@Configuration
public class RabbitMQConsumerConfig {

  //private final static String queueName = "client-order";
  private final static String exchangeName = "fanout-events";

  @Bean
  public ConnectionFactory connectionFactory() {
    CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
    connectionFactory.setAddresses("127.0.0.1:5672");
    connectionFactory.setUsername("guest");
    connectionFactory.setPassword("guest");
    connectionFactory.setVirtualHost("/");
    connectionFactory.setPublisherConfirms(true); //必须要设置  TODO
    return connectionFactory;
  }

  @Bean
  @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
  public RabbitTemplate rabbitTemplate() {
    RabbitTemplate template = new RabbitTemplate(connectionFactory());
    return template;
  }

  @Bean
  public AmqpAdmin amqpAdmin() {
    final RabbitAdmin rabbitAdmin = new RabbitAdmin(connectionFactory());
    FanoutExchange fanoutExchange = new FanoutExchange(exchangeName);
    rabbitAdmin.declareExchange(fanoutExchange);//create exchange if it not exists in server
    rabbitAdmin.declareQueue(queue());
    System.out.println("queueName:" + queue().getName());
    Binding binding = new Binding(queue().getName(), Binding.DestinationType.QUEUE, fanoutExchange.getName(), "", null);
    rabbitAdmin.declareBinding(binding);
    return rabbitAdmin;
  }


  @Bean
  public Queue queue() {
    return new Queue(UUID.randomUUID().toString(), true);
  }

  @Bean
  public FanoutExchange exchange() {
    return new FanoutExchange(exchangeName, true, false);
  }

  @Bean
  @DependsOn("amqpAdmin")
  public SimpleMessageListenerContainer container(ConnectionFactory connectionFactory, Queue queue) {
    SimpleMessageListenerContainer container = new SimpleMessageListenerContainer(connectionFactory());
    container.setQueues(queue());
    container.setExposeListenerChannel(true);
    container.setMaxConcurrentConsumers(1);
    container.setConcurrentConsumers(1);
    container.setAcknowledgeMode(AcknowledgeMode.MANUAL); //设置确认模式手工确认
    container.setMessageListener((ChannelAwareMessageListener) (message, channel) -> {
      byte[] body = message.getBody();
      System.out.println("receive msg : " + new String(body));

      ConsumeResult consumeResult = consumeMessage(message);
      switch (consumeResult){
        case ACCEPTED:
          channel.basicAck(message.getMessageProperties().getDeliveryTag(), false); //确认消息成功消费
          break;
        case FAILED:
          channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, true); //确认消息消费失败
          break;
        case REJECTED:
          channel.basicReject(message.getMessageProperties().getDeliveryTag(), false); //无法处理的消息，拒绝
          break;
      }
    });
    return container;
  }

  private ConsumeResult consumeMessage(Message message){
    try{
      boolean success = processMsg(message.getBody());
      if(success){
        return ConsumeResult.ACCEPTED;
      }else{
        if(message.getMessageProperties().isRedelivered()){
          return ConsumeResult.REJECTED;
        }else{
          return ConsumeResult.FAILED;
        }
      }
    }catch (TransactionException transEx){
      return ConsumeResult.FAILED;
    }catch (UnsupportedOperationException unsupportEx){
      return ConsumeResult.REJECTED;
    }catch (RuntimeException ex){
      return ConsumeResult.FAILED;
    }

  }

  private boolean processMsg(byte[] msgData){
    try {
      System.out.println("process msg started...");
      return ThreadLocalRandom.current().nextBoolean();
    }catch (Throwable throwable){
      System.out.println("occurred unknown exception");
      return false;
    }
  }

  enum ConsumeResult{
    ACCEPTED,
    FAILED,
    REJECTED,
    ;
  }
}
