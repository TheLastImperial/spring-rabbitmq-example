package com.tli.consumer.services.impl;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.tli.consumer.api.models.rq.PaymentStatusRQ;
import com.tli.consumer.services.interfaces.ConsumerService;
import com.tli.consumer.services.interfaces.PaymentService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Profile("rabbit")
@AllArgsConstructor
@Service
@Slf4j
public class RabbitConsumerServiceImpl implements ConsumerService{
    private PaymentService paymentService;

    @RabbitListener(queues = "${app.mq.queue}")
    public void readMessage(PaymentStatusRQ rq) {
        log.info("Data received: {}", rq);
        paymentService.updateStatus(rq);
    }
}
