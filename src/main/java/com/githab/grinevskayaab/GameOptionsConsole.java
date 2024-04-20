package com.githab.grinevskayaab;

import java.util.ArrayList;
import java.util.Scanner;

public class GameOptionsConsole implements GameOptions {
    @Override
    public ArrayList<Player> getPlayer() {
        ArrayList<Player> players = new ArrayList<>();
        Scanner input = new Scanner(System.in);

        System.out.println("Введите режим игры: 1 - я + бот, 2 - бот + бот ");
        int mode = input.nextInt();
        input.close();

        int counterPlayers = 2;
        for (int i = 0; i < counterPlayers; i++) {
            if (mode == 1 && i == 0) {
                Scanner inputName = new Scanner(System.in);
                System.out.println("Введите ваше имя:");
                players.add(new PlayerHuman(inputName.nextLine()));
                inputName.close();
            } else {
                players.add(new PlayerComputer("Computer" + (i + 1)));
            }
        }

        return players;
    }

    @Override
    public Integer getMaxRounds() {
        Scanner input = new Scanner(System.in);
        System.out.println("Введите количество раундов до победы:");
        return input.nextInt();
    }

}
