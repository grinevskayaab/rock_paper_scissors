package com.githab.grinevskayaab;

public class Main {
    public static void main(String[] args) {
//        GameRockPaperScissors game = new GameRockPaperScissors(new GameOptionsConsole());
//        game.start();

        GameRockPaperScissors game = new GameRockPaperScissors(new GameOptionsTest());
        game.start();

    }
}