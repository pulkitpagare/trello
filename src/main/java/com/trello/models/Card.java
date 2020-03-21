package com.trello.models;

import java.util.UUID;

public class Card {

    private String id;

    private User assignedUser;

    private String description;

    public Card(User assignedUser) {
        this.id = UUID.randomUUID().toString();
        this.assignedUser = assignedUser;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public User getAssignedUser() {
        return assignedUser;
    }

    public void setAssignedUser(User assignedUser) {
        this.assignedUser = assignedUser;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
