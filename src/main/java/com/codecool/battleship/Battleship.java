package com.codecool.battleship;

import com.codecool.battleship.display.Display;
import com.codecool.battleship.input.Input;

public class Battleship {
    private static Display display;
    private static Input inputs;
    private static Game game;
    public static boolean run;

    private Battleship() {
        display = new Display();
        inputs = new Input();
        game = new Game();
        run = true;
    }

    private static void mainMenu(){
        display.displayMenu();
        int chosenMode = inputs.menuInput();
        switch (chosenMode){
            case 0:
                run = false;
                break;
            case 1:
                game.newGame();
            case 2:
                display.highScore();
            default:
                display.wrongInput();
                mainMenu();
        }
    }

    public static void main(String args[]){
        while (run){
            mainMenu();
        }
    }
}
