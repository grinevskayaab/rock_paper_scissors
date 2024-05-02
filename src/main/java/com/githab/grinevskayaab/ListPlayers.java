package com.githab.grinevskayaab;

import java.util.Map;

public class ListPlayers {
    private final Map<String, Integer> listPlayer = Map.of();

    public Map<String, Integer> getListPlayer() {
        return listPlayer;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        listPlayer.forEach((key, value) -> result.append(key).append(": ").append(value).append("\n"));
        return result.toString();
    }
}
