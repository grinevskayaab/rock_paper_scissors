package com.githab.grinevskayaab;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class FileLeaderboard implements Leaderboard {
    @Override
    public String getLeaderboard() {
        ListPlayers leaderTable = new ListPlayers();
        try {
            ObjectMapper mapper = new ObjectMapper();
            leaderTable = mapper.readValue(new File("leaderboard.json"), ListPlayers.class);
        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла");
            e.printStackTrace();
        }
        return leaderTable.toString();
    }


    @Override
    public void changeLeaderboard(String name) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            ListPlayers leaderTable = mapper.readValue(new File("leaderboard.json"), ListPlayers.class);

            leaderTable.getListPlayer().merge(name, 1, Integer::sum);

            mapper.writeValue(new File("leaderboard.json"), leaderTable);
        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла");
            e.printStackTrace();
        }
    }

}
