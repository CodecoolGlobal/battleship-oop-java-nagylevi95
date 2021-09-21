package com.codecool.battleship.squares;

public class Square {
    private final int X;
    private final int Y;
    private SquareStatus squareStatus;

    public Square(int x, int y, SquareStatus status) {
        X = x;
        Y = y;
        squareStatus = SquareStatus.EMPTY;
    }

    public int getX() {
        return X;
    }

    public int getY() {
        return Y;
    }

    public SquareStatus getSquareStatus() {
        return squareStatus;
    }

    public void setSquareStatus(SquareStatus squareStatus) {
        this.squareStatus = squareStatus;
    }

    public String graphic(){
        String square;
        switch (squareStatus){
            case EMPTY:
                square = "";
                break;
            case SHIP:
                square = "";
                break;
            case HIT:
                square = "";
                break;
            case MISSED:
                square = "";
                break;
            case SUNK:
                square = "";
                break;
            default:
                square = "";
                break;
        }
        return square;
    }
}
