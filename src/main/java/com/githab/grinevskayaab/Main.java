package com.githab.grinevskayaab;


public class Main {
    public static void main(String[] args) {
        GameRockPaperScissors game = new GameRockPaperScissors();
        if(game.startOptionsIsCorrect()) {
            game.createPlayers();
            game.playGame();
        } else {
            System.out.println("Невозможно начать игру с такими параметрами");
        }
    }
}