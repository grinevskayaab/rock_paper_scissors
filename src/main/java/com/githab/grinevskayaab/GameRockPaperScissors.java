package com.githab.grinevskayaab;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GameRockPaperScissors {
    private final Integer maxRounds;
    private final List<Player> players;

    public GameRockPaperScissors(GameOptions gameOptions) {
        this.maxRounds = gameOptions.getMaxRounds();
        this.players = gameOptions.getPlayers();
    }

    public void start() {
        do {
            throwHands();
            showResultRound(getWinPlayers());
        } while (!gameEnd());
    }

    private void showResultRound(List<Player> winPlayers) {
        if (winPlayers.isEmpty()) {
            createLog("В этом раунде нет победителя\n");
        } else {
            addScorePlayers(winPlayers);
            showScore();
        }
    }

    private void addScorePlayers(List<Player> winPlayers) {
        for (Player player : winPlayers) {
            player.addScore();
        }
    }

    private List<Player> getWinPlayers() {
        List<Player> winPlayers = new ArrayList<>();
        for (Player player : players) {
            boolean beats = false;
            Hand hand = player.getLastHand();

            for (Player otherPlayer : players) {
                Hand otherHand = otherPlayer.getLastHand();
                if (hand.equals(otherHand)) continue;
                beats = hand.beats(otherHand);
                if (!beats) break;
            }

            if (beats) winPlayers.add(player);
        }
        return winPlayers;
    }

    private void throwHands() {
        for (Player player : players) {
            player.getHand();
            createLog(player.getName() + " выбрал " + player.getLastHand().getName());
        }
    }

    private boolean gameEnd() {
        boolean result = false;
        for (Player player : players) {
            if (Objects.equals(player.getScore(), maxRounds)) {
                result = true;
                createLog("Победитель - " + player.getName());
                break;
            }
        }
        return result;
    }

    private void showScore() {
        createLog("Текущий счет:");
        for (Player player : players) {
            createLog(player.getName() + "-" + player.getScore());
        }
        createLog("");
    }

    private void createLog(String log) {
        System.out.println(log);
    }
}
