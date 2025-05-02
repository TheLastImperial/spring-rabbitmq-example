package com.tli.consumer.services.interfaces;

import com.tli.consumer.api.models.rq.PaymentStatusRQ;

public interface ConsumerService {
    public void readMessage(PaymentStatusRQ rq);
}
