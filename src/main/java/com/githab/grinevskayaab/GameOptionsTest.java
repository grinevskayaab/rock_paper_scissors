package com.githab.grinevskayaab;

import java.util.ArrayList;

public class GameOptionsTest implements GameOptions {
    @Override
    public ArrayList<Player> getPlayer() {
        ArrayList<Player> players = new ArrayList<>();

        int counterPlayers = 3;
        for (int i = 0; i < counterPlayers; i++) {
            players.add(new PlayerComputer("Computer" + (i + 1)));
        }

        return players;
    }

    @Override
    public Integer getMaxRounds() {
        return 3;
    }
}
