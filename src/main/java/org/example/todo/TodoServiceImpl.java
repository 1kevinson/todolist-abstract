package org.example.todo;

import java.time.LocalDate;
import java.util.List;

public class TodoServiceImpl implements TodoService {

    private final TodoRepository repository;

    public TodoServiceImpl(TodoRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Todo> fetchAllTodos() {
        return repository.findAll();
    }

    @Override
    public Todo createTodo(String title, LocalDate date, boolean completed) {
        Todo todoToSave = new Todo(title, date, completed);
        return repository.add(todoToSave);
    }

    @Override
    public void deleteOneTodo(int todoId) {
        repository.deleteById(todoId);
    }
}
