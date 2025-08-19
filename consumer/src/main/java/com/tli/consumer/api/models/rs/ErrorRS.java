package com.tli.consumer.api.models.rs;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ErrorRS {
    private String message;
    private String error;
    private Integer status;
}
