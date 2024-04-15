package com.githab.grinevskayaab;

public class Player {
    private final String name;
    private int points = 0;

    Player(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void addPoint() {
        this.points++;
    }

    public int getPoint(){
        return this.points;
    }

    GameItem getItem() {
        return null;
    }
}
