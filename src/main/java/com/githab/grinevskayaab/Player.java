package com.githab.grinevskayaab;

public class Player {
    private final String name;
    private final String type;
    private int points = 0;

    Player(String type, String name) {
        this.type = type;
        this.name = name;
    }


    public String getName() {
        return this.name;
    }

    public void addPoint() {
        this.points++;
    }

    public int getPoint(){
        return this.points;
    }

    public GameItem getItem() {
        //позиция - выбирается игроком или рандомное число от 0 до длины массива
        byte positionItem = (this.type.equals("people")) ? GetInfoFromConsole.getItemPosition() : (byte) (Math.random() * GameItem.availableItems.length);
        return new GameItem(positionItem);
    }
}
