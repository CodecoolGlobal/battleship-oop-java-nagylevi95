package com.codecool.battleship;

import com.codecool.battleship.display.Display;
import com.codecool.battleship.input.Input;

public class Battleship {
    private static Display display;
    private static Input inputs;
    public boolean hasWon;

    private Battleship() {
        display = new Display();
        inputs = new Input();
        hasWon = false;
    }

    private static void mainMenu(){
        display.menuDisplay();
        int chosenmode = inputs.menuInput();
    }

    public static void main(String args[]){
        mainMenu();
    }
}
