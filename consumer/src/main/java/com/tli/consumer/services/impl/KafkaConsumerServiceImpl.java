package com.tli.consumer.services.impl;

import org.springframework.context.annotation.Profile;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.tli.consumer.api.models.rq.PaymentStatusRQ;
import com.tli.consumer.services.interfaces.ConsumerService;
import com.tli.consumer.services.interfaces.PaymentService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor
@Profile("kafka")
@Service
@Slf4j
public class KafkaConsumerServiceImpl implements ConsumerService {
  private final PaymentService paymentService;

  @KafkaListener( topics = "${app.mq.queue}",
    properties={"spring.json.value.default.type=com.tli.consumer.api.models.rq.PaymentStatusRQ"}
  )
  @Override
  public void readMessage(PaymentStatusRQ rq) {
    log.info("Data received: {}", rq);
    paymentService.updateStatus(rq);
  }
}
