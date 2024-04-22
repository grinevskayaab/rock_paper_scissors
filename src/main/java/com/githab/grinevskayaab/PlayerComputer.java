package com.githab.grinevskayaab;

public class PlayerComputer extends Player {
    public PlayerComputer(String name) {
        super(name);
    }

    @Override
    public void getHand() {
        Hand[] hands = Hand.values();
        this.lastHand =  hands[(int) (Math.random() * hands.length)];
    }
}
