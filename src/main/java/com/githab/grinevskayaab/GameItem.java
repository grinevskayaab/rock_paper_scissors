package com.githab.grinevskayaab;

import java.util.ArrayList;

public class GameItem {
    public final String type;
    public final ArrayList <String> itemWhoWins = new ArrayList<>(); //коллекция типов предметов, которые выигравают данный
    static final String[] availableItems = {"rock", "paper", "scissors"}; //доступные предметы

    public GameItem(byte typePosition) {
        this.type = availableItems[typePosition];
        switch (this.type) {
            case "rock" -> this.itemWhoWins.add("paper");
            case "paper" -> this.itemWhoWins.add("scissors");
            case "scissors" -> this.itemWhoWins.add("rock");
        }
    }
}
