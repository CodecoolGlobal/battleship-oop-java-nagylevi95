package com.codecool.battleship.display;

import com.codecool.battleship.Util;
import com.codecool.battleship.player.Player;
import com.codecool.battleship.ship.ShipType;
import com.codecool.battleship.square.Square;

public class Display {
    public void displayMenu(){
        System.out.println("[1]Player vs. Player");
        System.out.println("[2]Player vs. Unbeatable AI");
        System.out.println("[3]Highscores");
        System.out.println("[0]Exit");
    }

    public void placementSelection(){
        System.out.println("[1]Manual placement");
        System.out.println("[2]Automatic placement");
    }

    public void wrongInput(){
        System.out.println("Invalid input, try again!");
    }

    public void clearConsole(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public void displayBoard(Square[][] ocean, boolean isHidden){
        String header = Util.makeHeader(ocean.length);
        System.out.println(header);
        for (int i = 0; i < ocean.length; i++){
            StringBuilder row;
            if (i < 10){
                row = new StringBuilder(" " + i);
            }
            else{
                row = new StringBuilder(i);
            }
            for ( int j = 0; j < ocean.length; j++){
                if(isHidden && ocean[i][j].graphic().equals("\uD83D\uDEA2")){
                    row.append("\uD83D\uDCA8");
                }
                else{
                    row.append(ocean[i][j].graphic());
                }
            }
            System.out.println(row);
        }
    }

    public void provideName(){
        System.out.println("Please provide me your nickname!");
    }

    public void printWinner(String player){
        System.out.println(player + " won the game!");
    }

    public void providePlacementCoo(ShipType shipType){
        System.out.println("Please provide a coordinate for "+shipType+". The length of this ship is: "+shipType.getLength());
    }
    public void provideDir(){
        System.out.println("Please select the direction of the placed ship! (N,S,E,W)");
    }

    public void provideShootCoo(){
        System.out.println("Please provide a coordinate to shoot!");
    }

    public void displayPlayerRound(String name){
        System.out.println("Your turn to fire " + name + "!");
    }

    public void displayShotSquare(){
        System.out.println("That square has been targeted before! Pick a different target!");
    }
}
