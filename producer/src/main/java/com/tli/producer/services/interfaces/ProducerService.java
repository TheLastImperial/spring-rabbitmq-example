package com.tli.producer.services.interfaces;

import com.tli.producer.api.models.rq.PaymentStatusRQ;

public interface ProducerService {
    public void sendMessage(PaymentStatusRQ rq);
}
