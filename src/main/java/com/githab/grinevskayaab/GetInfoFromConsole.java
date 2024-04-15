package com.githab.grinevskayaab;

import java.util.Scanner;

public interface GetInfoFromConsole {
    static int getRounds() {
        String roundStr = scanValue("Введите количество раундов:");
        if (isNumber(roundStr) && !roundStr.equals("0")) return Integer.parseInt((roundStr));
        else return 0; // ошибка
    }

    static String getName() {
        return scanValue("Введите ваше имя:");
    }

    static byte getMode() {
        String modeStr = scanValue("Введите режим игры:\n 1 - я + компьютер\n 2 - компьютер + компьютер");
        String testStr = "12";
        if (isNumber(modeStr) && testStr.contains(modeStr)) return Byte.parseByte(modeStr);
        else return 0; // ошибка
    }

    static byte getItemPosition() {
        String positionItemStr = scanValue("Выберите предмет: 1 - rock, 2 - paper, 3 - scissors");
        String testStr = "123";
        return testStr.contains(positionItemStr) ? (byte) ((Byte.parseByte(positionItemStr)) - 1) : ((byte) (Math.random() * GameItem.availableItems.length));
    }

    static String scanValue(String outputStr) {
        System.out.println(outputStr);
        Scanner input = new Scanner(System.in);
        return input.nextLine();
    }

    static boolean isNumber(String str) {
        for (char c : str.toCharArray()) {
            if (c < '0' || c > '9') return false;
        }
        return true;
    }
}
