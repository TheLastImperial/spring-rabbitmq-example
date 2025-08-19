package com.tli.consumer.services.interfaces;

import com.tli.consumer.api.models.rq.PaymentStatusRQ;
import com.tli.consumer.api.models.rs.PaymentRS;

public interface PaymentService {
    public PaymentRS updateStatus(PaymentStatusRQ rq);
    public PaymentRS get(Long id);
}
