package com.example.boilerplate.model.request;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TodoRequest {

    private String title;
    private String description;
    private Boolean finished;
}
