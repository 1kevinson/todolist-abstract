package org.example.todo;

import java.time.LocalDate;
import java.util.List;

public interface TodoService {

    List<Todo> fetchAllTodos();

    Todo createTodo(String title, LocalDate date, boolean completed);

    void deleteOneTodo(int todoId);
}
