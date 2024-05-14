package com.githab.grinevskayaab.gameOptions;

import com.githab.grinevskayaab.player.Player;
import com.githab.grinevskayaab.player.PlayerComputer;

import java.util.ArrayList;
import java.util.List;

public class GameOptionsTest implements GameOptions {
    @Override
    public List<Player> getPlayers() {
        List<Player> players = new ArrayList<>();

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
