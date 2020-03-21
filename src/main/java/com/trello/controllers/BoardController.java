package com.trello.controllers;

import com.trello.models.Board;
import com.trello.models.Card;
import com.trello.models.List;
import com.trello.models.User;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.HashMap;

@RestController
public class BoardController {

    private static HashMap<String, Board> boards ;
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
        board.getMembers().put(userId, user);
        return "assigned successfully";
    }

    @PostMapping("/boards/{id}/lists")
    public String assignList(@PathVariable String id){
        if (boards == null && boards.getOrDefault(id, null) == null){
            return "Board doesn't exists";
        }
        List list = new List();
        Board board = boards.get(id);
        board.getLists().put(list.getId(), list);
        return "id : "+list.getId()+" list assigned successfully";
    }

    @GetMapping("/boards/{id}/lists")
    public HashMap<String, List> getAllList(@PathVariable String id) throws Exception {
        if (boards == null && boards.getOrDefault(id, null) == null){
            throw new Exception("Board with "+id+" doesn't exists");
        }
        return boards.get(id).getLists();
    }

    @PostMapping("/boards/{id}/lists/{list_id}/cards")
    public Card getAllList(@PathVariable String id , @PathVariable String listId, @RequestParam String userId) throws Exception {
        if (boards == null && boards.getOrDefault(id, null) == null){
            throw new Exception("Board with "+id+" doesn't exists");
        }
        if (!boards.get(id).getLists().containsKey(listId)){
            throw new Exception("List with "+listId+" doesn't exists");
        }
        if(!boards.get(id).getMembers().containsKey(userId)){
            throw new Exception("User with "+userId+" doesn't exists");
        }
        List list = boards.get(id).getLists().get(listId);
        Card card = new Card(boards.get(id).getMembers().get(userId));
        list.getCards().add(card);
        return card;
    }
}
