package com.codecool.battleship.ship;

import java.util.List;

public class Ship {
    List<Square> position = new List<Square>();
    int life;
    String Player;

    public Ship(List<Square> position) {
        this.position = position;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public String getPlayer() {
        return Player;
    }

    public void setPlayer(String player) {
        Player = player;
    }

}
