package com.githab.grinevskayaab;

public class PlayerComputer extends Player {
    public PlayerComputer(String name) {
        super(name);
    }

    @Override
    public Hand getHand() {
        Hand[] hands = Hand.values();
        return hands[(int) (Math.random() * hands.length)];
    }
}
