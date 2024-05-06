package com.githab.grinevskayaab.player;

import com.githab.grinevskayaab.hand.Hand;

public abstract class Player {
    private final String name;
    private Integer score = 0;
    protected Hand lastHand;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void addScore() {
        this.score++;
    }

    public Integer getScore(){
        return this.score;
    }
    public Hand getLastHand() {
        return lastHand;
    }

    public abstract void getHand();
}
