package com.githab.grinevskayaab;

import java.util.HashSet;
import java.util.Set;

public class GameRockPaperScissors implements GetInfoFromConsole {
    final int roundCounter;
    public int playersCounter = 2;
    public byte mode; // 1- человек + компьютер; 2 - компьютер + компьютер

    Player[] players = new Player[playersCounter];

    GameRockPaperScissors() {
        this.roundCounter = GetInfoFromConsole.getRounds();
        this.mode = GetInfoFromConsole.getMode();
    }


    public void createPlayers() {
        for (int i = 0; i < this.playersCounter; i++) {
            //если нужен человек - добавляем на 1-ой итареции
            if (this.mode == 1 && i == 0)
                players[i] = new Player("people", GetInfoFromConsole.getName());
            else players[i] = new Player("computer", "computer" + (i + 1));
        }
    }

    public boolean startOptionsIsCorrect() {
        return this.roundCounter > 0 && (this.mode == 1 || this.mode == 2);
    }

    private void createLog(String log) {
        System.out.println(log);
    }

    private int getWinnerThisRound(GameItem[] items) {
        //проверяем дубликаты (если они есть - победителя нет)
        Set<String> set = new HashSet<>();
        for (GameItem item : items) {
            if (set.contains(item.type)) return -1;
            else set.add(item.type);
        }

        int winnerPosition = -1;
        for (int i = 0; i < items.length && winnerPosition == -1; i++) {
            GameItem checkedItem = items[i]; //проверяемый элемент
            boolean itemWin = true; // по умолчанию считаем победителем
            //перебор остальных предметов коллекции
            for (int j = i + 1; j < items.length; j++) {
                //если нашелся в коллекции предмет сильнее проверяемого - проигрыш
                if (checkedItem.itemWhoWins.contains(items[j].type)) {
                    itemWin = false;
                    break;
                }
            }
            //не нашлось предмета сильнее - выигрыш
            if (itemWin) winnerPosition = i;
        }

        return winnerPosition;
    }

    private void showCurrentPoints() {
        StringBuilder log = new StringBuilder("Текущий счет: \n");
        for (Player player : players) {
            log.append(player.getName()).append(" - ").append(player.getPoint()).append("\n");
        }
        createLog(new String(log));
    }

    private int getWinnerAllGame() {
        for (int j = 0; j < players.length; j++) {
            if (players[j].getPoint() == this.roundCounter) return j;
        }
        return -1;
    }


    public void playGame() {
        int winnerPosition = -1;
        for (int i = 0; winnerPosition == -1; i++) {
            createLog("Раунд " + (i + 1) + ":\n");
            GameItem[] itemsThisRound = new GameItem[players.length]; //предметы в этом раунде

            for (int j = 0; j < players.length; j++) {
                itemsThisRound[j] = players[j].getItem(); //получаем предметы для каждого игрока
                createLog("Игрок " + players[j].getName() + " выбрал " + itemsThisRound[j].type);
            }

            int winnerPositionInThisRound = getWinnerThisRound(itemsThisRound); // вернет либо позицию игрока, либо -1(нет победителя)
            if (winnerPositionInThisRound == -1) {
                createLog("\nПобедителя нет, переиграем раунд");
                i--;
            } else {
                createLog("\nВыиграл игрок " + players[winnerPositionInThisRound].getName());
                players[winnerPositionInThisRound].addPoint(); //добавляем очки
                showCurrentPoints(); //показываем счет
                winnerPosition = getWinnerAllGame(); //проверяем есть ли победитель
            }
        }

        createLog("Выиграл игрок " + players[winnerPosition].getName());
    }
}
