package com.githab.grinevskayaab.game;

import com.githab.grinevskayaab.leaderboard.Leaderboard;

import java.util.Scanner;

public class GameMenu {
    private final Scanner scanner = new Scanner(System.in);
    private final GameRockPaperScissors game;
    private final Leaderboard leaderboard;

    public GameMenu(GameRockPaperScissors game, Leaderboard leaderboard) {
        this.game = game;
        this.leaderboard = leaderboard;
    }

    public void run() {
        Integer gameAction = getAction(); // 1 - играть, 2 - Таблица
        if(gameAction == 2) {
            String leaderboardString = leaderboard.getLeaderboard();
            System.out.println(leaderboardString);
        } else {
            game.start();
        }
    }

    private Integer getAction() {
        System.out.println("Выберите пункт:\n 1 - играть\n 2 - Показать таблицу со счетом игроков");
        return scanner.nextInt();
    }
}
