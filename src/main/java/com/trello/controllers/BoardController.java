package com.trello.controllers;

import com.trello.models.Board;
import com.trello.models.User;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import java.util.HashMap;

@RestController
public class BoardController {

    private  static HashMap<String, Board> boards ;
    @PostMapping("/boards")
    public Board createBoard(@NotBlank @RequestParam String name){
        if (boards == null){
            boards = new HashMap<>();
        }
        Board board = new Board(name);
        boards.put(board.getId(), board);
        return board;
    }

    @GetMapping("/boards")
    public HashMap<String, Board> getAllBoards(){
        return boards;
    }

    @GetMapping("/boards/{id}")
    public Board findBoardById(@PathVariable String id){
        if (boards != null && boards.containsKey(id)){
            return boards.get(id);
        }
        return null;
    }

    @PostMapping("/boards/{id}/users")
    public String assignMembersToBoard(@PathVariable String id, @RequestParam String userId){
        if (UserController.users == null || UserController.users.getOrDefault(userId, null) == null){
            return "User doesn't exists";
        } else if (boards.getOrDefault(id, null) == null){
            return "Board doesn't exists";
        }
        User user = UserController.users.get(userId);
        Board board = boards.get(id);
        board.getMembers().add(user);
        return "assigned successfully";
    }

//    @PostMapping("/boards/{id}/lists")
//    public String assignList(@PathVariable String id, @RequestParam String listId){
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
