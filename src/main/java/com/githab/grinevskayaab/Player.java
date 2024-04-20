package com.githab.grinevskayaab;

public abstract class Player {
    private final String name;
    private Integer score = 0;

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

    public abstract Hand getHand();
}
