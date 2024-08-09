package com.example.boilerplate.exception.model;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class ErrorDTO {

    private String errorCode;
    private String message;
    private String reason;
    private Date date;
}
