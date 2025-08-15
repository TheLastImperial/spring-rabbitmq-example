package com.tli.producer.services.impl;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.tli.producer.api.models.rq.PaymentStatusRQ;
import com.tli.producer.services.interfaces.ProducerService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Profile("rabbit")
@Service
public class RabbitProducerServiceImpl implements ProducerService {
    private Queue queue;
    private RabbitTemplate rabbitTemplate;

    public void sendMessage(PaymentStatusRQ rq) {
        rabbitTemplate.convertAndSend(queue.getName(), rq);
    }

}
