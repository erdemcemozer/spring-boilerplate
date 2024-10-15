package com.example.boilerplate.converter;

import com.example.boilerplate.model.dto.TodoDTO;
import com.example.boilerplate.model.entity.Todo;
import com.example.boilerplate.model.request.TodoRequest;
import org.springframework.stereotype.Component;

@Component
public class TodoConverter {

    public TodoDTO toDTO(Todo todo) {
        return TodoDTO
                .builder()
                .id(todo.getId())
                .createDate(todo.getCreateDate())
                .updateDate(todo.getUpdateDate())
                .title(todo.getTitle())
                .description(todo.getDescription())
                .finished(todo.getFinished())
                .build();
    }

    public Todo toEntity(TodoRequest request) {
        return Todo
                .builder()
                .title(request.title())
                .description(request.description())
                .finished(request.finished())
                .build();
    }
}
