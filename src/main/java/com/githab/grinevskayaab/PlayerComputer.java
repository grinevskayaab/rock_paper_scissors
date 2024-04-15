package com.githab.grinevskayaab;

public class PlayerComputer extends Player {
    PlayerComputer(String name) {
        super(name);
    }

    @Override
    public GameItem getItem() {
        //позиция - выбирается игроком или рандомное число от 0 до длины массива
        return new GameItem((byte) (Math.random() * GameItem.availableItems.length));
    }
}
