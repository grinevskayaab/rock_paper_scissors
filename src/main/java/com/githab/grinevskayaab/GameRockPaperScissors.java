package com.githab.grinevskayaab;

public class GameRockPaperScissors extends GetInfoFromConsole {
    public int roundCounter;
    public int playersCounter = 3;
    public byte mode; // 1- человек + компьютер; 2 - компьютер + компьютер

    Player[] players = new Player[playersCounter];

    GameRockPaperScissors() {
        this.roundCounter = getRounds();
        this.mode = getMode();
    }


    public void createPlayers() {
        for (int i = 0; i < this.playersCounter; i++) {
            //если нужен человек - добавляем на 1-ой итареции
            if (this.mode == 1 && i == 0)
                players[i] = new PlayerHuman(getName());
            else players[i] = new PlayerComputer("computer" + (i + 1));
        }
    }

    public boolean startOptionsIsCorrect() {
        return this.roundCounter > 0 && (this.mode == 1 || this.mode == 2);
    }


    int getWinnerThisRound(GameItem[] items) {
        int winnerPosition = -1;
        for (int i = 0; i < items.length && winnerPosition == -1; i++) {
            GameItem checkedItem = items[i]; //проверяемый элемент
            boolean itemWin = true; // по умолчанию считаем победителем
            //перебор остальных предметов коллекции
            for (int j = 0; j < items.length; j++) {
                if(j == i) continue;
                //если нашелся в коллекции предмет сильнее проверяемого - проигрыш
                if (items[j].type.equals(items[i].type) ||checkedItem.itemWhoWins.contains(items[j].type)) {
                    itemWin = false;
                    break;
                }
            }
            //не нашлось предмета сильнее - выигрыш
            if (itemWin) winnerPosition = i;
        }

        return winnerPosition;
    }

    void showCurrentPoints() {
        StringBuilder log = new StringBuilder("Текущий счет: \n");
        for (Player player : players) {
            log.append(player.getName()).append(" - ").append(player.getPoint()).append("\n");
        }
        createLog(new String(log));
    }

    int getWinnerAllGame() {
        for (int j = 0; j < players.length; j++) {
            if (players[j].getPoint() == this.roundCounter) return j;
        }
        return -1;
    }
}
