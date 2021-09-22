package com.codecool.battleship.square;

public enum SquareStatus {
    EMPTY("\uD83D\uDCA8"),
    SHIP("\uD83D\uDEA2"),
    HIT("\uD83D\uDCA5"),
    SUNK("\uD83C\uDF0A"),
    MISSED("\uD83D\uDCA6");

    private final String graphic;

    SquareStatus(String graphic) {
        this.graphic = graphic;
    }

    public String getGraphic() {
        return graphic;
    }
}
