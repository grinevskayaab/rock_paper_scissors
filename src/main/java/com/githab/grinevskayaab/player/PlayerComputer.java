package com.githab.grinevskayaab.player;

import com.githab.grinevskayaab.hand.Hand;

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
