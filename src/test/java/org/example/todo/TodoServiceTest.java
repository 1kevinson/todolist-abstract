package org.example.todo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import java.time.LocalDate;
import java.util.List;

import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@DisplayName("Unit tests for Service")
@ExtendWith(MockitoExtension.class)
public class TodoServiceTest {

    @Mock
    private TodoRepository todoRepository;


    @Test
    @DisplayName("Retrieve all todos in database ")
    void shouldRetrieveAllTodosInDatabase(){
        // Arrange
        List<Todo> allTodos = List.of(
                new Todo("hello Dominique", LocalDate.now(),false),
                new Todo("hello Dalhia", LocalDate.now(),true),
                new Todo("hello Jessy", LocalDate.now(),false)
        );

        when(todoRepository.findAll()).thenReturn(allTodos);
        // Act
        TodoService service = new TodoServiceImpl(todoRepository);
        List<Todo> actual = service.fetchAllTodos();

        // Assert
        Assertions.assertEquals(allTodos, actual);

        verify(todoRepository).findAll();
        verifyNoMoreInteractions(todoRepository);
    }

    @Test
    @DisplayName("Create one todo and save it in the database")
    void shouldInsertOneTodosInDatabase(){
        // Arrange
        Todo expected = new Todo("hello created todo", LocalDate.now(),false);

        when(todoRepository.add(any(Todo.class))).thenReturn(expected);
        // Act
        TodoService service = new TodoServiceImpl(todoRepository);
        Todo actual = service.createTodo("fake",LocalDate.now(), true);

        // Assert
        Assertions.assertEquals(expected, actual);

        verify(todoRepository).add(any(Todo.class));
        verifyNoMoreInteractions(todoRepository);
    }


    @Test
    @DisplayName("Delete one todo in the database")
    void shouldDeleteOneTodoInDatabase(){
        // Arrange

        // Act
        TodoService service = new TodoServiceImpl(todoRepository);
        service.deleteOneTodo(5);
        // Assert
        verify(todoRepository).deleteById(anyInt());
        verifyNoMoreInteractions(todoRepository);
    }
}
