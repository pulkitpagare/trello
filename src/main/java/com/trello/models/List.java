package com.trello.models;

import java.util.ArrayList;

public class List {

    private String id;

    private ArrayList<Card> cards;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
