package com.trello.controllers;

import com.trello.models.User;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
public class UserController {

    public static HashMap<String, User> users ;
    @PostMapping("/users")
    public User createUser(@RequestParam String name, @RequestParam String email){
        User user = new User(name, email);
        if (users == null){
            users = new HashMap<String, User>();
        }
        users.put(user.getId(), user);
        return user;
    }
    @GetMapping("/users")
    public HashMap<String, User> getAllUsers(){
        return users;
    }

    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable String id){
        return users.getOrDefault(id, null);
    }
}
