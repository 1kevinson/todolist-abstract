package org.example.todo;

import java.util.List;
import java.util.Optional;

public interface TodoRepository {

    Todo add(Todo todo);

    List<Todo> findAll();

    default Todo update(int id) {
        return null;
    }

    default Optional<Todo> findOneById(int id) {
        return Optional.empty();
    }

    void deleteById(int id);
}
