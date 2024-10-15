package com.example.boilerplate.model.request;

import lombok.*;

@Builder
public record TodoRequest(
        String title,
        String description,
        Boolean finished
) {
}