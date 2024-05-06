package com.githab.grinevskayaab.player;


import com.githab.grinevskayaab.hand.Hand;

import java.util.Scanner;

public class PlayerHuman extends Player {
     public PlayerHuman(String name) {
        super(name);
    }

    @Override
    public void getHand() {
        Hand[] hands = Hand.values();
        StringBuilder outputStr = new StringBuilder("Выберите руку:");
        for(Hand hand : hands) {
            outputStr.append("\n").append(hand.ordinal()).append(" - ").append(hand.getName());
        }
        System.out.println(outputStr);
        Scanner input = new Scanner(System.in);

        this.lastHand = hands[input.nextInt()];
    }
}
