package com.sevarev.todo.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sevarev.todo.dao.ListItemDao;
import com.sevarev.todo.models.TodoListItem;

@RestController
@RequestMapping("/listItem")
@CrossOrigin
public class ListItemController {
    private final ListItemDao listItemDao;
        
    public ListItemController(ListItemDao listItemDao) {
        this.listItemDao = listItemDao;
    }

    @GetMapping("/{listId}")
    public List<TodoListItem> getListItemsByListId(@PathVariable  int listId) {
        return listItemDao.getListItemsByListId(listId);
    }

    @PostMapping("/")
    public void createListItem(@RequestBody TodoListItem item) {
        listItemDao.createListItem(item.getName(), item.getListId());
    }

    @DeleteMapping("/{listId}/{id}")
    public void deleteListItem(@PathVariable int id, @PathVariable int listId) {
        listItemDao.deleteListItem(id, listId);
    }

    @PutMapping("/complete/{listId}/{id}")
    public void completeListItem(@PathVariable int id, @PathVariable int listId) {
        listItemDao.completeListItem(id, listId);
    }

    @PutMapping("/uncomplete/{listId}/{id}")
    public void uncompleteListItem(@PathVariable int id, @PathVariable int listId) {        listItemDao.uncompleteListItem(id, listId);
    }

}
