package com.example.boilerplate.controller;

import com.example.boilerplate.converter.TodoConverter;
import com.example.boilerplate.model.dto.TodoDTO;
import com.example.boilerplate.model.request.TodoRequest;
import com.example.boilerplate.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/todo")
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;
    private final TodoConverter todoConverter;

    @GetMapping
    public List<TodoDTO> getTodos() {
        return todoService.getTodos();
    }

    @GetMapping(value = "/{id}")
    public TodoDTO getTodo(@PathVariable String id) {
        return todoService.getTodo(id);
    }

    @PostMapping
    public TodoDTO createTodo(@RequestBody TodoRequest todoRequest) {
        return todoService.createTodo(todoConverter.toEntity(todoRequest));
    }

    @PutMapping(value = "/{id}")
    public TodoDTO updateTodo(@PathVariable String id,
                              @RequestBody TodoRequest todoRequest) {
        return todoService.updateTodo(id, todoConverter.toEntity(todoRequest));
    }

    @DeleteMapping(value = "/{id}")
    public TodoDTO deleteTodo(@PathVariable String id) {
        return todoService.deleteTodo(id);
    }

    @DeleteMapping
    public ResponseEntity<?> deleteTodos() {
        todoService.deleteTodos();
        return ResponseEntity.ok().build();
    }
}
