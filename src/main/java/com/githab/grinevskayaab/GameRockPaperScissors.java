package com.githab.grinevskayaab;

import java.util.ArrayList;
import java.util.Objects;

public class GameRockPaperScissors {
    private final Integer maxRounds;
    private final ArrayList<Player> players;

    public GameRockPaperScissors(GameOptions gameOptions) {
        this.maxRounds = gameOptions.getMaxRounds();
        this.players = gameOptions.getPlayers();
    }

    public void start() {
        while (true) {
            ArrayList<Hand> hands = new ArrayList<>();
            ArrayList<Player> winPlayers = new ArrayList<>();
            for (Player player : players) {
                Hand hand = player.getHand();
                hands.add(hand);
                createLog(player.getName() + " выбрал " + hand.getName());
            }

            for (int i = 0; i < hands.size(); i++) {
                boolean beats = false;
                Hand hand = hands.get(i);

                for (Hand otherHand : hands) {
                    if (hand.equals(otherHand)) continue;
                    beats = hand.beats(otherHand);
                    if (!beats) break;
                }

                if (beats) winPlayers.add(players.get(i));
            }

            if (winPlayers.isEmpty()) {
                createLog("В этом раунде нет победителя\n");
            } else {
                for (Player player : winPlayers) {
                    player.addScore();
                }
                showScore(players);
                if (gameEnd(players)) break;
            }
        }
    }

    private boolean gameEnd(ArrayList<Player> players) {
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

    private void showScore(ArrayList<Player> players) {
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
