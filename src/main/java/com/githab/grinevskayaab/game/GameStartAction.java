package com.githab.grinevskayaab.game;

import com.githab.grinevskayaab.leaderboard.Leaderboard;

public class GameStartAction {
    private final GameRockPaperScissors game;
    private final Leaderboard leaderboard;
    private final GameMenu gameMenu;

    public GameStartAction(GameRockPaperScissors game, Leaderboard leaderboard, GameMenu gameMenu) {
        this.game = game;
        this.leaderboard = leaderboard;
        this.gameMenu = gameMenu;
    }

    public void run() {
        Integer gameAction = gameMenu.getAction(); // 1 - играть, 2 - Таблица
        if(gameAction == 2) {
            String leaderboardString = leaderboard.getLeaderboard();
            System.out.println(leaderboardString);
        } else {
            game.start();
        }
    }
}
