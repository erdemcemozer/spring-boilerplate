package com.example.boilerplate.exception;

import jakarta.validation.ConstraintDeclarationException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;

@Getter
@Setter
@Slf4j
@AllArgsConstructor
public class BaseException extends ConstraintDeclarationException {

    private String errorCode;
    private String message;
    private String reason;
    private Date date;
}
