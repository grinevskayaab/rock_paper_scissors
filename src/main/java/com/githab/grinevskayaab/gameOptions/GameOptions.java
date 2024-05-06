package com.githab.grinevskayaab.gameOptions;

import com.githab.grinevskayaab.player.Player;

import java.util.ArrayList;

public interface GameOptions {
    ArrayList<Player> getPlayers();

    Integer getMaxRounds();
}
