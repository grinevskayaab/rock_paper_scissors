package com.githab.grinevskayaab;

public class PlayerHuman extends Player {
    PlayerHuman(String name) {
        super( name);
    }

    @Override
    public GameItem getItem() {
        return new GameItem(GetInfoFromConsole.getItemPosition());
    }
}
