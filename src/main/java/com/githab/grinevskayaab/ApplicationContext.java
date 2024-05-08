package com.githab.grinevskayaab;

import com.githab.grinevskayaab.game.GameMenu;
import com.githab.grinevskayaab.game.GameRockPaperScissors;
import com.githab.grinevskayaab.gameOptions.GameOptions;
import com.githab.grinevskayaab.gameOptions.GameOptionsTest;
import com.githab.grinevskayaab.leaderboard.FileLeaderboard;
import com.githab.grinevskayaab.leaderboard.Leaderboard;


public class ApplicationContext {
    private final GameMenu gameMenu;

    public ApplicationContext() {
        Leaderboard leaderboard = new FileLeaderboard();
//        GameOptions gameOptions = new GameOptionsConsole();
        GameOptions gameOptions = new GameOptionsTest();
        GameRockPaperScissors game = new GameRockPaperScissors(gameOptions);
        this.gameMenu = new GameMenu(game, leaderboard);
    }

    public void run() {
        gameMenu.run();
    }
}
