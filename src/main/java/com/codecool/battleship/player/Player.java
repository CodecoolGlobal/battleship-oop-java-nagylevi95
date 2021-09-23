package com.codecool.battleship.player;

import com.codecool.battleship.ship.Ship;
import com.codecool.battleship.square.Square;
import com.codecool.battleship.square.SquareStatus;
import com.codecool.battleship.board.Board;

import java.util.Arrays;
import java.util.List;

public class Player {
    private List<Ship> ships;
    private String name;

    public Player(String name) {
        this.name = name;
    }

    public void shoot(Player enemyPlayer, int x, int y, Board board) {
        Square targetSquare = board.getOcean()[x][y];
        for (Ship ship : enemyPlayer.ships) {
            for (Square pos : ship.getPosition()) {
                if (pos == targetSquare) {
                    pos.setSquareStatus(SquareStatus.HIT);
                    if (ship.isSunk()){
                        markSunk(ship);
                    }
                    break;
                }
            }
        }
        if (targetSquare.getSquareStatus() == SquareStatus.EMPTY) {
            targetSquare.setSquareStatus(SquareStatus.MISSED);
        }
    }

    private void markSunk(Ship ship){
        for (Square square:ship.getPosition()){
            square.setSquareStatus(SquareStatus.SUNK);
        }
        ship.setSunk(true);
    }

    public boolean isAlive() {
        for (Ship ship : ships) {
            if (!ship.getSunk()) {
                return true;
            }
        }
        return false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Ship> getShips() {
        return ships;
    }

    public void setShips(List<Ship> ships) {
        this.ships = ships;
    }
}
