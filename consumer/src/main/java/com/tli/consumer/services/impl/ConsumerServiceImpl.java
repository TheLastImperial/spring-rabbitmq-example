package com.tli.consumer.services.impl;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import com.tli.consumer.api.models.rq.PaymentStatusRQ;
import com.tli.consumer.services.interfaces.ConsumerService;
import com.tli.consumer.services.interfaces.PaymentService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ConsumerServiceImpl implements ConsumerService{
    private PaymentService paymentService;

    @RabbitListener(queues = "${app.rabbitmq.queue}")
    public void readMessage(PaymentStatusRQ rq) {
        paymentService.updateStatus(rq);
    }
}
