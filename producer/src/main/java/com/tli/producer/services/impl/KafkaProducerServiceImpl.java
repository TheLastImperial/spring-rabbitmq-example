package com.tli.producer.services.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.tli.producer.api.models.rq.PaymentStatusRQ;
import com.tli.producer.services.interfaces.ProducerService;

@Profile("kafka")
@Service
public class KafkaProducerServiceImpl implements ProducerService{
  private KafkaTemplate<String, Object> kafkaTemplate;
  private String topic;
  public KafkaProducerServiceImpl(KafkaTemplate<String, Object> kafkaTemplate,
    @Value("${app.mq.queue}") String topic){
      this.kafkaTemplate = kafkaTemplate;
      this.topic = topic;
  }

  @Override
  public void sendMessage(PaymentStatusRQ rq) {
    kafkaTemplate.send(topic, rq);
  }

}
