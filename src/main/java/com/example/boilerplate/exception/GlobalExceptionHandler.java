package com.example.boilerplate.exception;

import com.example.boilerplate.exception.model.ErrorDTO;
import com.example.boilerplate.exception.subexceptions.TodoNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(BaseException.class)
    public ResponseEntity<ErrorDTO> handleException(BaseException ex) {
        log.error("[handleException::BaseException] Exception::{}", ex.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(createErrorDto(ex));
    }

    @ExceptionHandler(TodoNotFoundException.class)
    public ResponseEntity<ErrorDTO> handleException(TodoNotFoundException ex) {
        log.error("[handleException::TodoNotFoundException] Exception::{}", ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(createErrorDto(ex));
    }

    public ErrorDTO createErrorDto(BaseException ex) {
        return ErrorDTO.builder()
                .errorCode(ex.getErrorCode())
                .message(ex.getMessage())
                .reason(ex.getReason())
                .date(ex.getDate())
                .build();
    }
}
