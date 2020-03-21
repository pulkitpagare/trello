package com.trello.models;

import java.util.ArrayList;

public class List {

    private String id;

    private ArrayList<Card> cards;

    public String getId() {
        return id;
    }
    public List(){
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
