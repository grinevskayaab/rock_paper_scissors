package com.githab.grinevskayaab.gameOptions;

import com.githab.grinevskayaab.player.Player;

import java.util.List;

public interface GameOptions {
    List<Player> getPlayers();

    Integer getMaxRounds();
}
