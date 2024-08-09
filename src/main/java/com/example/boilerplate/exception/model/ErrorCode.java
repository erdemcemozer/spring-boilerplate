package com.example.boilerplate.exception.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    DEFAULT_ERROR("E000", "Sorry, there was a problem.", "An unexpected error occurred!"),
    TODO_NOT_FOUND_ERROR("E001", "Sorry we couldn't find this todo.", "This todo doesn't exist!");

    private final String errorCode;
    private final String message;
    private final String reason;
}
