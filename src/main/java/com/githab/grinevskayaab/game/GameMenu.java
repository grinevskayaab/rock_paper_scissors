package com.githab.grinevskayaab.game;

import java.util.Scanner;

public class GameMenu {
    private final Scanner scanner = new Scanner(System.in);

    public Integer getAction() {
        System.out.println("Выберите пункт:\n 1 - играть\n 2 - Показать таблицу со счетом игроков");
        return scanner.nextInt();
    }
}
