package com.trello.models;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.UUID;

public class Board {
    private String id;

    @NotBlank(message = "name should not be blank")
    private String boardName;

    private ArrayList<User> members;

    private ArrayList<List> lists;

    public Board(String boardName) {
        this.id = UUID.randomUUID().toString();
        this.boardName = boardName;
        this.members = new ArrayList<>();
        this.lists = new ArrayList<>();
    }

    public String getBoardName() {
        return boardName;
    }

    public void setBoardName(String boardName) {
        this.boardName = boardName;
    }

    public ArrayList<User> getMembers() {
        return members;
    }

    public void setMembers(ArrayList<User> members) {
        this.members = members;
    }

    public ArrayList<List> getLists() {
        return lists;
    }

    public void setLists(ArrayList<List> lists) {
        this.lists = lists;
    }

    public String getId() {
        return id;
    }
}
