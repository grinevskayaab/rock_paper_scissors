package com.githab.grinevskayaab;


public class Main {
    public static void main(String[] args) {
        GameRockPaperScissors game = new GameRockPaperScissors();
        if (game.startOptionsIsCorrect()) {

            game.createPlayers();
            int winnerPosition = -1;
            for (int i = 0; winnerPosition == -1; i++) {
                game.createLog("Раунд " + (i + 1) + ":\n");
                GameItem[] itemsThisRound = new GameItem[game.players.length]; //предметы в этом раунде

                for (int j = 0; j < game.players.length; j++) {
                    itemsThisRound[j] = game.players[j].getItem(); //получаем предметы для каждого игрока
                    game.createLog("Игрок " + game.players[j].getName() + " выбрал " + itemsThisRound[j].type);
                }

                int winnerPositionInThisRound = game.getWinnerThisRound(itemsThisRound); // вернет либо позицию игрока, либо -1(нет победителя)
                if (winnerPositionInThisRound == -1) {
                    game.createLog("\nПобедителя нет, переиграем раунд");
                    i--;
                } else {
                    game.createLog("\nВыиграл игрок " + game.players[winnerPositionInThisRound].getName());
                    game.players[winnerPositionInThisRound].addPoint(); //добавляем очки
                    game.showCurrentPoints(); //показываем счет
                    winnerPosition = game.getWinnerAllGame(); //проверяем есть ли победитель
                }
            }
            game.createLog("Выиграл игрок " + game.players[winnerPosition].getName());
        } else {
            System.out.println("Невозможно начать игру с такими параметрами");
        }
    }
}