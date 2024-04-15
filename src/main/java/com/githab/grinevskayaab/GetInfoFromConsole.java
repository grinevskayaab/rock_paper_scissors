package com.githab.grinevskayaab;

import java.util.Scanner;

public class GetInfoFromConsole implements GetInfo {
    @Override
    public int getRounds() {
        String roundStr = scanValue("Введите количество раундов:");
        if (GetInfo.isNumber(roundStr) && !roundStr.equals("0")) return Integer.parseInt((roundStr));
        else return 0; // ошибка
    }

    @Override
    public String getName() {
        return scanValue("Введите ваше имя:");
    }

    @Override
    public byte getMode() {
        String modeStr = scanValue("Введите режим игры:\n 1 - я + компьютер\n 2 - компьютер + компьютер");
        String testStr = "12";
        if (GetInfo.isNumber(modeStr) && testStr.contains(modeStr)) return Byte.parseByte(modeStr);
        else return 0; // ошибка
    }


    public static byte getItemPosition() {
//        String positionItemStr = scanValue("Выберите предмет: 1 - rock, 2 - paper, 3 - scissors, 4 - колодец");
        String positionItemStr = scanValue("Выберите предмет: 1 - rock, 2 - paper, 3 - scissors");
        if (positionItemStr.isEmpty() || !"123".contains(positionItemStr))
            return ((byte) (Math.random() * GameItem.availableItems.length));
        return (byte) ((Byte.parseByte(positionItemStr)) - 1);
    }

    static String scanValue(String outputStr) {
        System.out.println(outputStr);
        Scanner input = new Scanner(System.in);
        return input.nextLine();
    }

    public void createLog(String log) {
        System.out.println(log);
    }

}
