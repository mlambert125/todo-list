package com.sevarev.todo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.sevarev.todo.models.TodoList;

@Component
public class ListDao {
    private final JdbcTemplate jdbcTemplate;

    public ListDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<TodoList> getListsByUser (String userId) {
        return jdbcTemplate.query(
            "select * from lists where userid = ?", 
            this::mapResultSetToTodoList,
            userId
        );
    }

    public TodoList getList(String id) {
        return jdbcTemplate.queryForObject(
            "select * from lists where id = ?", 
            this::mapResultSetToTodoList,
            id
        );
    }

    public void createList(String name, String userId) {
        jdbcTemplate.update("insert into lists (name, userid) values (?, ?)", name, userId);
    }

    public void deleteList(int id, String userId) {
        jdbcTemplate.update("delete from lists where id = ? and userid=?", id, userId);
    }

    public void updateList(int id, String name, String userId) {
        jdbcTemplate.update("update lists set name = ? where id = ? and userid=?", name, id, userId);
    }

    public TodoList mapResultSetToTodoList(ResultSet rs, int rowNum) throws SQLException {
        TodoList list = new TodoList();
        list.setId(rs.getInt("id"));
        list.setName(rs.getString("name"));
        list.setUserId(rs.getString("userId"));
        list.setCreatedAt(rs.getTimestamp("createdAt").toLocalDateTime());
        return list;
    }
}
