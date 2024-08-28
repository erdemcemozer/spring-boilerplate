package com.example.boilerplate.service;

import com.example.boilerplate.model.dto.TodoDTO;
import com.example.boilerplate.model.entity.Todo;

import java.util.List;

public interface TodoService {

    TodoDTO createTodo(Todo todo);
    TodoDTO updateTodo(String id, Todo todo);
    TodoDTO deleteTodo(String id);
    void deleteTodos();
    List<TodoDTO> getTodos();
    TodoDTO getTodo(String id);
}
