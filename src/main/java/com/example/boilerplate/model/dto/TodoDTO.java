package com.example.boilerplate.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.util.Date;

@Builder
public record TodoDTO(
        String id,
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date createDate,
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date updateDate,
        String title,
        String description,
        Boolean finished
) {
}
