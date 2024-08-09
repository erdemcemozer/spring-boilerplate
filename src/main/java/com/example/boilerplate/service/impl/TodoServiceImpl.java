package com.example.boilerplate.service.impl;

import com.example.boilerplate.converter.TodoConverter;
import com.example.boilerplate.exception.subexceptions.TodoNotFoundException;
import com.example.boilerplate.model.dto.TodoDTO;
import com.example.boilerplate.model.entity.Todo;
import com.example.boilerplate.repository.TodoRepository;
import com.example.boilerplate.service.TodoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService {

    private final TodoRepository todoRepository;
    private final TodoConverter todoConverter;

    @Override
    public TodoDTO createTodo(Todo todo) {
        log.info("[TodoServiceImpl] createTodo");
        return todoConverter.toDTO(todoRepository.save(todo));
    }

    @Override
    public TodoDTO updateTodo(Long id, Todo todo) {
        log.info("[TodoServiceImpl] updateTodo with id::{}", id);
        Optional<Todo> optionalTodo = todoRepository.findById(id);

        if (optionalTodo.isPresent()) {
            Todo updatedTodo = optionalTodo.get();
            updatedTodo.setTitle(todo.getTitle());
            updatedTodo.setDescription(todo.getDescription());
            updatedTodo.setFinished(todo.getFinished());
            updatedTodo.setUpdateDate(new Date());
            return todoConverter.toDTO(todoRepository.save(updatedTodo));
        } else {
            throw new TodoNotFoundException();
        }
    }

    @Override
    public TodoDTO deleteTodo(Long id) {
        log.info("[TodoServiceImpl] deleteTodo with id::{}", id);
        return todoRepository.findById(id)
                .map(todo -> {
                    todoRepository.delete(todo);
                    return todoConverter.toDTO(todo);
                })
                .orElseThrow(TodoNotFoundException::new);
    }

    @Override
    public void deleteTodos() {
        log.info("[TodoServiceImpl] deleteTodos");
        todoRepository.deleteAll();
    }

    @Override
    public List<TodoDTO> getTodos() {
        log.info("[TodoServiceImpl] getTodos");
        return todoRepository
                .findAll()
                .stream()
                .map(todoConverter::toDTO)
                .toList();
    }

    @Override
    public TodoDTO getTodo(Long id) {
        log.info("[TodoServiceImpl] getTodo with id::{}", id);
        return todoConverter
                .toDTO(todoRepository
                        .findById(id)
                        .orElseThrow(TodoNotFoundException::new));
    }
}
