package com.figer.reliable.producer;

import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by figer on 24/07/2017.
 */
@Configuration
@ComponentScan(basePackages = "com.figer.reliable.producer")
public class RabbitMQProducerConfig {
  @Value("exchange.name")
  public static String exchangeName;

  @Bean
  public ConnectionFactory connectionFactory() {
    CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
    connectionFactory.setHost("localhost");
    /*connectionFactory.setUsername(configuration.getGeneralMqUser());
    connectionFactory.setPassword(configuration.getGeneralMqPwd());*/
    /*connectionFactory.setVirtualHost(configuration.getGeneralMqVhost());*/
    connectionFactory.setPublisherConfirms(true); //必须要设置
    return connectionFactory;
  }
}
