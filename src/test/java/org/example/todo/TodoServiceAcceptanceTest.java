package org.example.todo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.*;

public class TodoServiceAcceptanceTest {

    final TodoRepository repository = new InMemoryTodoDatas();

    final List<Todo> expectedTodoList = List.of(
            new Todo("hello t1", LocalDate.now(),false),
            new Todo("hello t2", LocalDate.now(),false),
            new Todo("hello t3", LocalDate.now(),false)
    );

    @Test
    @DisplayName("Acceptance test for retrieving all todos in database")
    void shouldRetrieveAllDatasFromDatabase() {
        //Inject InMemory Repository in service
        final TodoService service = new TodoServiceImpl(repository);

        // Insert Bulk Todos
        service.createTodo("hello t1", LocalDate.now(), false);
        service.createTodo("hello t2", LocalDate.now(), false);
        service.createTodo("hello t3", LocalDate.now(), false);

        // Assert all are matched
        Assertions.assertEquals(expectedTodoList, repository.findAll());
    }

    // Nested Class for inMemoryDatabase
    static class InMemoryTodoDatas implements TodoRepository {

        Map<Integer, Todo> todoDatas = new HashMap<>();

        @Override
        public Todo add(Todo todo) {
            todoDatas.put(todo.getId(), todo);
            return todo;
        }

        @Override
        public List<Todo> findAll() {
            return new ArrayList<>(todoDatas.values());
        }

        @Override
        public void deleteById(int id) {
            todoDatas.remove(id);
        }
    }
}
