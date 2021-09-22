package com.codecool.battleship.board;

import com.codecool.battleship.input.Input;
import com.codecool.battleship.player.Player;
import com.codecool.battleship.ship.Ship;
import com.codecool.battleship.ship.ShipType;
import com.codecool.battleship.square.Square;
import com.codecool.battleship.square.SquareStatus;

import java.util.LinkedList;
import java.util.List;

public class BoardFactory {

    //theoretically works with the smallest ships
    public void manualPlacement(Player player, Board board, Input input) {
        List<Ship> ships = new LinkedList<>();
        List<Square> positions;
        Square[][] ocean = board.getOcean();
        for (ShipType shipType : ShipType.values()) {
            //display info about the ship length and ask for coordinates
            positions = placeShips(ocean, shipType, input);
            ships.add(new Ship(positions, shipType, player));
        }
        player.setShips(ships);
    }

    private List<Square> placeShips(Square[][] ocean, ShipType shipType, Input input) {
        int[] firstCoo = input.cooInput();
        List<Square> shipPositions = new LinkedList<>();
        if (!isEmptyField(firstCoo, ocean) && !isValidCoo(firstCoo, ocean)) {
            return placeShips(ocean, shipType, input);
        }
        //ask user for direction

        int [] direction = input.getDirection();

        Square targetSquare = ocean[firstCoo[0]][firstCoo[1]];
        targetSquare.setSquareStatus(SquareStatus.SHIP);
        shipPositions.add(targetSquare);
        int i = 1;
        while (i < shipType.getLength()){
            placeShip(ocean, firstCoo, shipPositions, direction);
            i++;
        }
        return shipPositions;
    }

    private void placeShip(Square[][] ocean, int[] firstCoo, List<Square> shipPositions, int[] direction) {
        Square targetSquare;
        targetSquare = ocean[firstCoo[0] + direction[0]][firstCoo[1]+ direction[1]];
        targetSquare.setSquareStatus(SquareStatus.SHIP);
        shipPositions.add(targetSquare);
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
