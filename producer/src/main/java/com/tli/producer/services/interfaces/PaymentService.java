package com.tli.producer.services.interfaces;

import com.tli.producer.api.models.rq.PaymentRQ;
import com.tli.producer.api.models.rq.PaymentStatusRQ;
import com.tli.producer.api.models.rs.PaymentRS;

public interface PaymentService {
    public PaymentRS create(PaymentRQ rq);

    public void updateStatus(PaymentStatusRQ rq);
}
