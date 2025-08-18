package com.tli.consumer.api.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tli.consumer.api.models.rs.PaymentRS;
import com.tli.consumer.services.interfaces.PaymentService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@AllArgsConstructor
@RequestMapping(path="/payments")
@RestController
@Tag(
    name="PaymentController",
    description = "Controller manage Payment Data"
)
public class PaymentController {
    private final PaymentService paymentService;

    @Operation(
        summary = "Get a payment by id"
    )
    @GetMapping("/{id}")
    public ResponseEntity<PaymentRS> get(@PathVariable Long id) {
        return ResponseEntity.ok(paymentService.get(id));
    }
}
