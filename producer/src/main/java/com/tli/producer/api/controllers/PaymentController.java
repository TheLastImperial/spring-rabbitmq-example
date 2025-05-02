package com.tli.producer.api.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tli.producer.api.models.rq.PaymentRQ;
import com.tli.producer.api.models.rq.PaymentStatusRQ;
import com.tli.producer.api.models.rs.PaymentRS;
import com.tli.producer.services.interfaces.PaymentService;

import lombok.AllArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@AllArgsConstructor
@RestController
@RequestMapping(path="/payments")
public class PaymentController {
    private final PaymentService paymentService;

    @PostMapping
    public ResponseEntity<PaymentRS> postMethodName(@RequestBody PaymentRQ rq) {
        return ResponseEntity.ok(paymentService.create(rq));
    }

    @PostMapping("/update_status")
    public ResponseEntity<Void> postMethodName(@RequestBody PaymentStatusRQ rq) {
        paymentService.updateStatus(rq);
        return ResponseEntity
            .noContent()
            .build();
    }
}
