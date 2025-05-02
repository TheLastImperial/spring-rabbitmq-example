package com.tli.producer.services.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.tli.producer.api.models.rq.PaymentRQ;
import com.tli.producer.api.models.rq.PaymentStatusRQ;
import com.tli.producer.api.models.rs.PaymentRS;
import com.tli.producer.domain.entities.PaymentEntity;
import com.tli.producer.domain.repositories.PaymentRepository;
import com.tli.producer.services.interfaces.PaymentService;
import com.tli.producer.services.interfaces.ProducerService;

@Service
public class PaymentServiceImpl implements PaymentService {

    
    private String initStatus;
    private final PaymentRepository paymentRepository;
    private final ProducerService producerService;

    public PaymentServiceImpl(@Value("${app.payments.initStatus}") String initStatus,
        PaymentRepository paymentRepository, ProducerService producerService
    ){
        this.initStatus = initStatus;
        this.paymentRepository = paymentRepository;
        this.producerService = producerService;
    }

    public PaymentRS create(PaymentRQ rq) {
        PaymentEntity toSave = new PaymentEntity();
        BeanUtils.copyProperties(rq, toSave);
        toSave.setStatus(initStatus);
        PaymentEntity saved = paymentRepository.save(toSave);
        PaymentRS response = new PaymentRS();
        BeanUtils.copyProperties(saved, response);
        return response;
    }

    public void updateStatus(PaymentStatusRQ rq) {
        producerService.sendMessage(rq);
    }
}
