package com.trello.controllers;

import com.trello.models.Board;
import com.trello.models.List;
import com.trello.models.User;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.HashMap;

@RestController
public class ListController {
    HashMap<String, List> lists ;
    @PostMapping("/lists")
    public List createList(){
        if (lists == null){
            lists = new HashMap<>();
        }
        List list = new List();
        lists.put(list.getId(), list);
        return list;
    }

    @GetMapping("/lists")
    public HashMap<String, List> getAllLists(){
        return lists;
    }


//    @PostMapping("/lists/{id}/cards")
//    public String assignCardToLists(@PathVariable String id, @RequestParam String cardId){
//        if (UserController.users == null || UserController.users.getOrDefault(userId, null) == null){
//            return "User doesn't exists";
//        } else if (boards.getOrDefault(id, null) == null){
//            return "Board doesn't exists";
//        }
//        User user = UserController.users.get(userId);
//        Board board = boards.get(id);
//        board.getMembers().add(user);
//        return "assigned successfully";
//    }
}
