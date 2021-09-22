package com.codecool.battleship.board;

import com.codecool.battleship.input.Input;
import com.codecool.battleship.player.Player;
import com.codecool.battleship.ship.Ship;
import com.codecool.battleship.square.Square;
import com.codecool.battleship.square.SquareStatus;

import java.util.List;

public class BoardFactory {

    //theoretically works with the smallest ships
    public void manualPlacement(Player player, Board board, Input input) {
        List<Ship> ships = player.getShips();
        Square[][] ocean = board.getOcean();
        for (Ship ship : ships) {
            int[] startingCoo = input.userCoo();
            if (isValidCoo(startingCoo, ocean) && isEmptyField(startingCoo, ocean)) {
                // place small ship here
            }
        }
    }

    public boolean isValidCoo(int[] inputCoo, Square[][] ocean) {
        int length = ocean.length;
        return 0 <= inputCoo[0] && 0 <= inputCoo[1] && inputCoo[0] <= length && inputCoo[1] <= length;
    }

    public boolean isEmptyField(int[] inputCoo, Square[][] ocean) {
        Square targetSquare = ocean[inputCoo[0]][inputCoo[1]];
        return (targetSquare.getSquareStatus() == SquareStatus.EMPTY);
    }
}
