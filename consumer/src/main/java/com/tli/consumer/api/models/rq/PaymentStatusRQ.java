package com.tli.consumer.api.models.rq;

import lombok.Data;

@Data
public class PaymentStatusRQ {
    private Long id;
    private String status;
}
