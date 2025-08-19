package com.tli.producer.api.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tli.producer.api.models.rq.PaymentRQ;
import com.tli.producer.api.models.rq.PaymentStatusRQ;
import com.tli.producer.api.models.rs.PaymentRS;
import com.tli.producer.services.interfaces.PaymentService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@AllArgsConstructor
@RequestMapping(path="/payments")
@RestController
@Tag(name = "Payment controller",
    description = "Create and send update to MQ"
)
public class PaymentController {
    private final PaymentService paymentService;

    @ApiResponse(responseCode = "201")
    @Operation(summary = "create a new payment.")
    @PostMapping
    public ResponseEntity<PaymentRS> create(@RequestBody PaymentRQ rq) {
        return ResponseEntity.ok(paymentService.create(rq));
    }

    @ApiResponse(responseCode = "204")
    @Operation(summary = "Send new status to MQ")
    @PostMapping("/update_status")
    public ResponseEntity<Void> updateStatus(@RequestBody PaymentStatusRQ rq) {
        paymentService.updateStatus(rq);
        return ResponseEntity
            .noContent()
            .build();
    }
}
