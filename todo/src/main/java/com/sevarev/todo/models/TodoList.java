package com.sevarev.todo.models;

import java.time.LocalDateTime;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TodoList {
    private int id;
    private String name;
    private String userId;
    private LocalDateTime createdAt;
    private List<TodoListItem> items;
}
