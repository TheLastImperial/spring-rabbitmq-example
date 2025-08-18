package com.tli.consumer.services.interfaces;

import com.tli.consumer.api.models.rq.PaymentStatusRQ;
import com.tli.consumer.api.models.rs.PaymentRS;
import com.tli.consumer.domain.entities.PaymentEntity;

public interface PaymentService {
    public PaymentEntity updateStatus(PaymentStatusRQ rq);
    public PaymentRS get(Long id);
}
