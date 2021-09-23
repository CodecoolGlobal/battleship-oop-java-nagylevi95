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
        for (Ship ship : enemyPlayer.ships) {
            for (Square pos : ship.getPosition()) {
                if (pos.getX() == x && pos.getY() == y) {
                    pos.setSquareStatus(SquareStatus.HIT);
                    board.getOcean()[x][y].setSquareStatus(SquareStatus.HIT);

                    break;
                } else if (board.getOcean()[x][y].getSquareStatus() != (SquareStatus.HIT) && board.getOcean()[x][y].getSquareStatus() != (SquareStatus.HIT)) {
                    board.getOcean()[x][y].setSquareStatus(SquareStatus.MISSED);
                }
            }
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
