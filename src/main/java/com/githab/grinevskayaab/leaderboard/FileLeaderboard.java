package com.githab.grinevskayaab.leaderboard;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.githab.grinevskayaab.player.ListPlayers;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class FileLeaderboard implements Leaderboard {
    private final String FILE_PATH = "leaderboard.json";
    private final String FILE_EXIST = "Файл пуст";
    private final String FILE_ERROR = "Ошибка при чтении файла";

    private final ObjectMapper mapper = new ObjectMapper();
    private final File file = new File(FILE_PATH);

    @Override
    public String getLeaderboard() {
        String result = "";
        try {
            if (file.createNewFile()) {
                writeDefaultText();
                result = FILE_EXIST;
            } else {
                ListPlayers leaderTable = getLeaderTableFromFile();
                if (leaderTable.getListPlayer().isEmpty()) {
                    writeDefaultText();
                    result = FILE_EXIST;
                } else {
                    Map<String,Integer> sortLeaderTable = sortMapOfValue(leaderTable.getListPlayer());
                    result = convertMapToString(sortLeaderTable);
                }
            }
        } catch (IOException e) {
            System.out.println(FILE_ERROR);
            e.printStackTrace();
        }
        return result;
    }


    @Override
    public void changeLeaderboard(String name) {
        try {
            if (file.createNewFile()) {
                writeDefaultText();
                System.out.println(FILE_EXIST);
            } else {
                ListPlayers leaderTable = getLeaderTableFromFile();
                if (leaderTable.getListPlayer().isEmpty()) {
                    writeDefaultText();
                    leaderTable = getLeaderTableFromFile();
                }
                leaderTable.getListPlayer().merge(name, 1, Integer::sum);

                mapper.writeValue(file, leaderTable);
            }

        } catch (IOException e) {
            System.out.println(FILE_ERROR);
            e.printStackTrace();
        }
    }

    private ListPlayers getLeaderTableFromFile() throws IOException {
        return mapper.readValue(file, ListPlayers.class);
    }

    private String convertMapToString(Map<String, Integer> list) {
        StringBuilder result = new StringBuilder();
        list.forEach((key, value) -> result.append(key).append(": ").append(value).append("\n"));
        return result.toString();
    }

    private Map<String, Integer> sortMapOfValue(Map<String, Integer> list) {
        Map<String, Integer> newList = new TreeMap<>(
                Comparator.comparing(list::get).reversed());
        newList.putAll(list);
        return newList;
    }

    private void writeDefaultText() throws IOException {
        FileWriter writer = new FileWriter(FILE_PATH);
        writer.write("{\"listPlayer\": {}}");
        writer.close();
    }
}
