package com.tli.consumer.services.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.tli.consumer.api.models.rq.PaymentStatusRQ;
import com.tli.consumer.api.models.rs.PaymentRS;
import com.tli.consumer.domain.entities.PaymentEntity;
import com.tli.consumer.domain.repositories.PaymentRepository;
import com.tli.consumer.exceptions.UnprocessableEntityException;
import com.tli.consumer.services.interfaces.PaymentService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class PaymentServiceImpl implements PaymentService{
    private final PaymentRepository paymentRepository;

    @CachePut(value="payments", key = "#payment.id")
    public PaymentRS updateStatus(PaymentStatusRQ rq) {
        PaymentRS response = new PaymentRS();
        PaymentEntity toUpdate = paymentRepository.findById(rq.getId())
            .orElseThrow(UnprocessableEntityException::new);
        toUpdate.setStatus(rq.getStatus());
        PaymentEntity paymentUpdated = paymentRepository.save(toUpdate);
        BeanUtils.copyProperties(paymentUpdated, response);
        return response;
    }

    @Cacheable("payments")
    public PaymentRS get(Long id) {
        PaymentRS response = new PaymentRS();
        PaymentEntity payment = paymentRepository.findById(id)
            .orElseThrow(UnprocessableEntityException::new);
        BeanUtils.copyProperties(payment, response);
        return response;
    }
}
