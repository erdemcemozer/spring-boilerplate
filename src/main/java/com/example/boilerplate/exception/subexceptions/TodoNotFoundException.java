package com.example.boilerplate.exception.subexceptions;

import com.example.boilerplate.exception.BaseException;
import com.example.boilerplate.exception.model.ErrorCode;

import java.util.Date;

public class TodoNotFoundException extends BaseException {

    public TodoNotFoundException() {
        super(ErrorCode.TODO_NOT_FOUND_ERROR.getErrorCode(),
                ErrorCode.TODO_NOT_FOUND_ERROR.getMessage(),
                ErrorCode.TODO_NOT_FOUND_ERROR.getReason(),
                new Date());
    }
}
