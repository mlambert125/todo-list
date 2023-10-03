package com.sevarev.todo.controllers;
import java.util.List;

import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sevarev.todo.dao.ListDao;
import com.sevarev.todo.models.TodoList;

@RestController
@RequestMapping("/list")
@CrossOrigin    
public class ListController {
    private final ListDao listDao;

    public ListController(ListDao listDao) {
        this.listDao = listDao;
    }

    @GetMapping("/")
    public List<TodoList> getListsByUser (OAuth2AuthenticationToken principal) {
        String userId = principal.getPrincipal().getAttributes().get("email").toString();
        return listDao.getListsByUser(userId);
    }

    @PostMapping("/")
    public void createList(@RequestBody TodoList list, OAuth2AuthenticationToken principal) {
        String userId = principal.getPrincipal().getAttributes().get("email").toString();
        listDao.createList(list.getName(), userId);
    }

    @DeleteMapping("/{id}")
    public void deleteList(@PathVariable int id, OAuth2AuthenticationToken principal) {
        String userId = principal.getPrincipal().getAttributes().get("email").toString();
        listDao.deleteList(id, userId);
    }

    @PutMapping("/{id}")
    public void updateList(@PathVariable int id, @RequestBody TodoList list, OAuth2AuthenticationToken principal) {
        String userId = principal.getPrincipal().getAttributes().get("email").toString();
        listDao.updateList(id, list.getName(), userId);
    }
}
