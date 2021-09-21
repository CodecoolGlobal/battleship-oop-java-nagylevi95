package com.codecool.battleship.board;

import com.codecool.battleship.input.Input;
import com.codecool.battleship.player.Player;
import com.codecool.battleship.ship.Ship;
import com.codecool.battleship.square.Square;

import java.util.List;

public class BoardFactory {

    //theoretically works with the smallest ships
    public void manualPlacement(Player player, Board board, Input input) {
        List<Ship> ships = player.getShips();
        for (Ship ship : ships) {
            int[] startingCoo = input.cooInput();
            if (isValidCoo(startingCoo, board)) {
                // if the ship has one square, then place it
                }
            }
        }
    }

    public boolean isValidCoo(int[] inputCoo, Board board) {
        int length = board.getOcean().length;
        return 0 <= inputCoo[0] && 0 <= inputCoo[1] && inputCoo[0] <= length && inputCoo[1] <= length;
    }
}
