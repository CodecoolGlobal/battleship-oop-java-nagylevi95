package com.codecool.battleship.board;

import com.codecool.battleship.display.Display;
import com.codecool.battleship.input.Input;
import com.codecool.battleship.player.Player;
import com.codecool.battleship.ship.Ship;
import com.codecool.battleship.ship.ShipType;
import com.codecool.battleship.square.Square;
import com.codecool.battleship.square.SquareStatus;

import java.util.LinkedList;
import java.util.List;

public class BoardFactory {

    private final Display display = new Display();
    private final Input input = new Input();

    public void manualPlacement(Player player, Board board) {
        List<Ship> ships = new LinkedList<>();
        List<Square> positions;
        Square[][] ocean = board.getOcean();
        for (ShipType shipType : ShipType.values()) {
            board.display();
            positions = placeShips(ocean, shipType);
            markShips(positions);
            ships.add(new Ship(positions, shipType, player));

        }
        player.setShips(ships);
    }

    private List<Square> placeShips(Square[][] ocean, ShipType shipType) {
        display.providePlacementCoo(shipType);
        int[] firstCoo = input.userCoo();
        List<Square> shipPositions = new LinkedList<>();
        if (!isEmptyField(firstCoo, ocean) || !isValidCoo(firstCoo, ocean)) {
            display.wrongInput();
            return placeShips(ocean, shipType);
        }
        display.provideDir();
        int[] direction = input.getDirection();
        Square targetSquare = ocean[firstCoo[0]][firstCoo[1]];
        int i = 1;
        int[] nextCoo = new int[2];
        while (i < shipType.getLength()) {
            nextCoo[0] = firstCoo[0] + direction[0]*i;
            nextCoo[1] = firstCoo[1] + direction[1]*i;
            if (isValidCoo(nextCoo, ocean) && isEmptyField(nextCoo,ocean)) {
                placeShip(ocean, nextCoo, shipPositions);
                i++;
            }else {
                display.wrongInput();
                return placeShips(ocean, shipType);
            }
        }
        shipPositions.add(targetSquare);
        return shipPositions;
    }

    private void placeShip(Square[][] ocean, int[] nextCoo, List<Square> shipPositions) {
        Square targetSquare;
        targetSquare = ocean[nextCoo[0]][nextCoo[1]];
        shipPositions.add(targetSquare);
    }

    private void markShips(List<Square> shipPositions){
        for (Square position:shipPositions){
            position.setSquareStatus(SquareStatus.SHIP);
        }
    }

    public boolean isValidCoo(int[] inputCoo, Square[][] ocean) {
        int length = ocean.length;
        return 0 <= inputCoo[0] && 0 <= inputCoo[1] && inputCoo[0] < length && inputCoo[1] < length;
    }

    public boolean isEmptyField(int[] inputCoo, Square[][] ocean) {
        Square targetSquare = ocean[inputCoo[0]][inputCoo[1]];
        return (targetSquare.getSquareStatus() == SquareStatus.EMPTY);
    }
}
