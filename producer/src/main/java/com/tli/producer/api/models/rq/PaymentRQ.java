package com.tli.producer.api.models.rq;

import lombok.Data;

@Data
public class PaymentRQ {
    private String sendingAccount;
    private String receivingAccount;
    private Double amount;
}
