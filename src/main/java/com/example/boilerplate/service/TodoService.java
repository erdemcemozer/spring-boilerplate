package com.example.boilerplate.service;

import com.example.boilerplate.model.dto.TodoDTO;
import com.example.boilerplate.model.entity.Todo;

import java.util.List;

public interface TodoService {

    TodoDTO createTodo(Todo todo);
    TodoDTO updateTodo(Long id, Todo todo);
    TodoDTO deleteTodo(Long id);
    void deleteTodos();
    List<TodoDTO> getTodos();
    TodoDTO getTodo(Long id);
}
