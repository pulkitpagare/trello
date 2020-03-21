package com.trello.models;

import java.util.ArrayList;
import java.util.UUID;

public class List {

    private String id;

    private ArrayList<Card> cards;

    public String getId() {
        return id;
    }
    public List(){
        this.id = UUID.randomUUID().toString();
        this.cards = new ArrayList<>();
    }
    public void setId(String id) {
        this.id = id;
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public void setCards(ArrayList<Card> cards) {
        this.cards = cards;
    }
}
