package com.githab.grinevskayaab;

import java.util.Scanner;

public class GameMenu {
    public void start()  {
        System.out.println("Выберите пункт:\n 1 - играть\n 2 - Показать таблицу со счетом игроков");
        Scanner input = new Scanner(System.in);
        if (input.nextInt() == 2) {
            showLeaderboard();
            start();
        } else {
//            GameRockPaperScissors game = new GameRockPaperScissors(new GameOptionsConsole());
//            game.start();

            GameRockPaperScissors game = new GameRockPaperScissors(new GameOptionsTest());
            game.start();
        }
    }

    private void showLeaderboard() {
        Leaderboard leaderboard = new FileLeaderboard();
        System.out.println(leaderboard.getLeaderboard());
    }
}
