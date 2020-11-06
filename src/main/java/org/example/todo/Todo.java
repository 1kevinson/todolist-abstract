package org.example.todo;

import java.time.LocalDate;
import java.util.Objects;

public class Todo {

    private static int count = 1;
    private final int id;
    private final String title;
    private final LocalDate creationDate;
    private final boolean completed;

    public Todo(String title, LocalDate creationDate, boolean completed) {
        this.id = count++;
        this.title = title;
        this.creationDate = creationDate;
        this.completed = completed;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public boolean isCompleted() {
        return completed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Todo todo = (Todo) o;
        return completed == todo.completed &&
                title.equals(todo.title) &&
                creationDate.equals(todo.creationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, creationDate, completed);
    }
}
