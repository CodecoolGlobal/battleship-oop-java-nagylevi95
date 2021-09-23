package com.codecool.battleship;

import com.codecool.battleship.display.Display;
import com.codecool.battleship.game.Game;
import com.codecool.battleship.input.Input;

public class Battleship {
    private Display display;
    private Input inputs;
    private Game game;
    public boolean run;

    private Battleship() {
        display = new Display();
        inputs = new Input();
        game = new Game();
        run = true;
    }

    private void mainMenu(){
        while (run){
            display.displayMenu();
            int chosenMode = inputs.userInt();
            switch (chosenMode){
                case 0:
                    run = false;
                    break;
                case 1:
                    System.out.println("new game");
                    game.newGame();
                    break;
                case 2:
                    System.out.println("high score");
//                    display.highScore();
                    break;
                default:
                    display.wrongInput();
                    mainMenu();
            }
        }
    }

    public static void main(String args[]){
        new Battleship().mainMenu();
    }
}
