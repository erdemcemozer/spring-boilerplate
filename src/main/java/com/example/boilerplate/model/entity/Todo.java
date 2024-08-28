package com.example.boilerplate.model.entity;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "todos")
public class Todo {

    @Id
    private String id;

    @CreatedDate
    private Date createDate;
    @LastModifiedDate
    private Date updateDate;

    private String title;
    private String description;

    @Builder.Default
    private Boolean finished = false;
}
