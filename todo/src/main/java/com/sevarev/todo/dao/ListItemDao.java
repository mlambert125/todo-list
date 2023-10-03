package com.sevarev.todo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.sevarev.todo.models.TodoListItem;

@Component
public class ListItemDao {
    private final JdbcTemplate jdbcTemplate;

    public ListItemDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<TodoListItem> getListItemsByListId(int listId) {
        return jdbcTemplate.query(
            "select * from list_items where listId = ?", 
            this::mapResultSetToTodoListItem,
            listId
        );
    }

    public void createListItem(String name, int listId) {
        jdbcTemplate.update("insert into list_items (name, listid) values (?, ?)", name, listId);
    }

    public void deleteListItem(int id, int listId) {
        jdbcTemplate.update("delete from list_items where id = ? and listId=?", id, listId);
    }

    public void completeListItem(int id, int listId) {
        jdbcTemplate.update("update list_items set completed = true, completedAt = now() where id = ? and listId=?", id, listId);
    }

    public void uncompleteListItem(int id, int listId) {
        jdbcTemplate.update("update list_items set completed = false, completedAt = null where id = ? and listId=?", id, listId);
    }   

    public TodoListItem mapResultSetToTodoListItem(ResultSet rs, int rowNum) throws SQLException {
        TodoListItem item = new TodoListItem();
        item.setId(rs.getInt("id"));
        item.setName(rs.getString("name"));
        item.setCompleted(rs.getBoolean("completed"));
        item.setCreatedAt(rs.getTimestamp("createdAt").toLocalDateTime());
        
        if (rs.getTimestamp("completedAt") != null)
            item.setCompletedAt(rs.getTimestamp("completedAt").toLocalDateTime());

        return item;
    }
}
