package com.figer.reliable.producer;

import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by figer on 24/07/2017.
 */
@Component
public class RabbitMQEventSender {

  private static final String exchageName = "fanout-events";

  @Autowired
  private ConnectionFactory connectionFactory;

  private ConcurrentMap<String, EventMsg> unConfirmedMsg = new ConcurrentHashMap<>();
  private AtomicLong id = new AtomicLong();

  public RabbitMQEventSender() {
    startRetryScheduler();
  }

  public void send(Object message) {
    //1 insert msg into concurrentMap
    EventMsg eventMsg = new EventMsg(id.getAndIncrement() + "", message, System.currentTimeMillis());
    unConfirmedMsg.putIfAbsent(eventMsg.getMsgId(), eventMsg);

    //2 send to mq
    sendMsgToRabbitMQ(eventMsg);
  }

  private void sendMsgToRabbitMQ(EventMsg eventMsg){
    try {
      final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
      rabbitTemplate.setMandatory(true);//spring_listener_return_correlation
      rabbitTemplate.setExchange(exchageName);//TODO   eventType
      //2
      rabbitTemplate.setMessageConverter(new Jackson2JsonMessageConverter());

      rabbitTemplate.setConfirmCallback((correlationData, ack, cause) -> {
        if (ack) {
          //TODO ack confirm success and then remove msg from ConcurrentMap
          System.out.println("Msg {} 确认发送到mq" + correlationData.getId());
          unConfirmedMsg.remove(correlationData.getId());
        }else{
          System.out.println("Msg {} confirm ack return false, msgId" + correlationData.getId());
        }
      });

      rabbitTemplate.correlationConvertAndSend(eventMsg.getMsg(), new CorrelationData(eventMsg.getMsgId()));
    }catch (Throwable throwable){
      System.out.println("send msg to mq occurred error:{}" + throwable);
    }

  }

  public void startRetryScheduler() {
    //TODO  定时resend： 从ConcurrentMap读出较长时间未被ack掉的消息进行重发
    System.out.println("started RetryScheduler");
  }

  class EventMsg<Msg>{
    private String msgId;
    private Msg msg;
    private Long sendTimeMillis;

    public EventMsg(String msgId, Msg msg, Long sendTimeMillis) {
      this.msgId = msgId;
      this.msg = msg;
      this.sendTimeMillis = sendTimeMillis;
    }

    public String getMsgId() {
      return msgId;
    }

    public EventMsg setMsgId(String msgId) {
      this.msgId = msgId;
      return this;
    }

    public Msg getMsg() {
      return msg;
    }

    public EventMsg setMsg(Msg msg) {
      this.msg = msg;
      return this;
    }

    public Long getSendTimeMillis() {
      return sendTimeMillis;
    }

    public EventMsg setSendTimeMillis(Long sendTimeMillis) {
      this.sendTimeMillis = sendTimeMillis;
      return this;
    }
  }
}
