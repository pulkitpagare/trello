package com.trello.models;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public class Board {
    private String id;

    @NotBlank(message = "name should not be blank")
    private String boardName;

    private HashMap<String, User> members;

    private HashMap<String, List> lists;

    public Board(String boardName) {
        this.id = UUID.randomUUID().toString();
        this.boardName = boardName;
        this.members = new HashMap<>();
        this.lists = new HashMap<>();
    }

    public String getBoardName() {
        return boardName;
    }

    public void setBoardName(String boardName) {
        this.boardName = boardName;
    }

    public HashMap<String, User> getMembers() {
        return members;
    }

    public void setMembers(HashMap<String, User> members) {
        this.members = members;
    }

    public HashMap<String, List> getLists() {
        return lists;
    }

    public void setLists(HashMap<String, List> lists) {
        this.lists = lists;
    }

    public String getId() {
        return id;
    }
}
