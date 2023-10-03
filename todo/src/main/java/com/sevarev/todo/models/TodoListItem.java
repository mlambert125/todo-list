package com.sevarev.todo.models;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TodoListItem {
    private int id;
    private int listId;
    private String name;
    private LocalDateTime createdAt;
    private boolean completed;
    private LocalDateTime completedAt;
}
