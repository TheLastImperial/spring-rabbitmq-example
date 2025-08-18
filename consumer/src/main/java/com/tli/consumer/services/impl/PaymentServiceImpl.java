package com.tli.consumer.services.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.tli.consumer.api.models.rq.PaymentStatusRQ;
import com.tli.consumer.api.models.rs.PaymentRS;
import com.tli.consumer.domain.entities.PaymentEntity;
import com.tli.consumer.domain.repositories.PaymentRepository;
import com.tli.consumer.services.interfaces.PaymentService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class PaymentServiceImpl implements PaymentService{
    private final PaymentRepository paymentRepository;

    @Cacheable("payments")
    public PaymentEntity updateStatus(PaymentStatusRQ rq) {
        PaymentEntity toUpdate = paymentRepository.findById(rq.getId()).get();
        toUpdate.setStatus(rq.getStatus());
        return paymentRepository.save(toUpdate);
    }

    @CachePut(value="payments", key = "#payment.id")
    public PaymentRS get(Long id) {
        PaymentRS response = new PaymentRS();
        PaymentEntity payment = paymentRepository.findById(id).get();
        BeanUtils.copyProperties(payment, response);
        return response;
    }
}
