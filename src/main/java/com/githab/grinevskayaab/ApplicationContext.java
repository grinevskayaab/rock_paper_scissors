package com.githab.grinevskayaab;

import com.githab.grinevskayaab.game.GameMenu;
import com.githab.grinevskayaab.game.GameRockPaperScissors;
import com.githab.grinevskayaab.game.GameStartAction;
import com.githab.grinevskayaab.gameOptions.GameOptions;
import com.githab.grinevskayaab.gameOptions.GameOptionsConsole;
import com.githab.grinevskayaab.gameOptions.GameOptionsTest;
import com.githab.grinevskayaab.leaderboard.FileLeaderboard;
import com.githab.grinevskayaab.leaderboard.Leaderboard;


public class ApplicationContext {

    private final GameStartAction startAction;

    public ApplicationContext() {
        Leaderboard leaderboard = new FileLeaderboard();
//        GameOptions gameOptions = new GameOptionsConsole();
        GameOptions gameOptions = new GameOptionsTest();
        GameMenu gameMenu = new GameMenu();
        GameRockPaperScissors game = new GameRockPaperScissors(gameOptions);
        this.startAction = new GameStartAction(game, leaderboard, gameMenu);
    }

    public void run() {
        startAction.run();
    }
}
