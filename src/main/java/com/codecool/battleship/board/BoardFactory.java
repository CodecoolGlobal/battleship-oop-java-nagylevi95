package com.codecool.battleship.board;

import com.codecool.battleship.input.Input;

public class BoardFactory {

    //theoretically works with the smallest ships
    public void placement(Player player) {
        ships = player.ships;
        for (Ship ship : ships) {
            int[] startingCoo = Input.cooInput();
            if (isValidCoo(startingCoo)) {
                if (ship.location.length = 1) {
                    ship.location[0].x = startingCoo[0];
                    ship.location[1].x = startingCoo[1];
                }
            }
        }
    }

    public boolean isValidCoo(int[] inputCoo) {
        for (Square square : board.ocean) {
            if (square.x = inputCoo[0] || square.y = inputCoo[1]) {
                return true;
            }
        }
        return false;
    }

}
