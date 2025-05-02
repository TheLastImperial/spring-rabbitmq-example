package com.tli.consumer.api.models.rs;

import lombok.Data;

@Data
public class PaymentRS {
    private Long id;
    private String sendingAccount;
    private String receivingAccount;
    private Double amount;
    private String status;
}
