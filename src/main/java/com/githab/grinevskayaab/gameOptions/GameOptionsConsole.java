package com.githab.grinevskayaab.gameOptions;

import com.githab.grinevskayaab.player.Player;
import com.githab.grinevskayaab.player.PlayerComputer;
import com.githab.grinevskayaab.player.PlayerHuman;

import java.util.ArrayList;
import java.util.Scanner;

public class GameOptionsConsole implements GameOptions {
    private final Scanner scanner = new Scanner(System.in);
    @Override
    public ArrayList<Player> getPlayers() {
        ArrayList<Player> players = new ArrayList<>();

        System.out.println("Введите режим игры: 1 - я + бот, 2 - бот + бот ");
        int mode = scanner.nextInt();

        int counterPlayers = 2;
        if (mode == 1) {
            Player playerHuman = createPlayerHuman();
            players.add(playerHuman);
            counterPlayers--;
        }

        for (int i = 0; i < counterPlayers; i++) {
                players.add(new PlayerComputer("Computer" + (i + 1)));
        }

        return players;
    }

    private Player createPlayerHuman() {
        System.out.println("Введите ваше имя:");
        scanner.nextLine();
        String name = scanner.nextLine();

        return new PlayerHuman(name);
    }

    @Override
    public Integer getMaxRounds() {
        Scanner input = new Scanner(System.in);
        System.out.println("Введите количество раундов до победы:");
        return input.nextInt();
    }

}
