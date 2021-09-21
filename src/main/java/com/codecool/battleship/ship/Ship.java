package com.codecool.battleship.ship;

import com.codecool.battleship.squares.Square;

import java.util.HashSet;
import java.util.List;
import java.util.Stack;

public class Ship {
    private List<Square> position;
    private ShipType shipType;
    private Player player;
    private Boolean isSunk;

    public Ship(List<Square> position, ShipType shipType, Player player, Boolean isSunk) {
        this.position = position;
        this.shipType = shipType;
        this.player = player;
        this.isSunk = false;
    }



    public Player getPlayer() {
        return player;
    }
    

    public Boolean getSunk() {
        return isSunk;
    }

    public void setSunk(Boolean sunk) {
        isSunk = sunk;
    }

    public ShipType getShipType() {
        return shipType;
    }


}
