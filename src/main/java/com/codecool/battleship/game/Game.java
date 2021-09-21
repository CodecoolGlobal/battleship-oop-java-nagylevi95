package com.codecool.battleship.game;

import com.codecool.battleship.display.Display;
import com.codecool.battleship.input.Input;

public class Game {
    private Player firstPlayer;
    private Player secondPlayer;
    private Display display;
    private Input inputs;
    private Board board;
    private int turn;

    private int getTurn() {
        return turn;
    }

    private void setTurn(int turn) {
        this.turn = turn;
    }

    private Game() {
        turn = 1;
        board = new Board();
        display = new Display();
        inputs = new Input();
    }

    private void newGame(){
        name = input.userName();
        firstPlayer = new player(ships, name);
        name = input.userName();
        secondPlayer = new player(ships, name);
        display.boardFactory();
        choice = inputs.userInt();
        if (choice == 1){
            boardFactory manual;
        }else{
            BoardFactory random;
        }
        play();
        display.printResult();
    }

    private void play(){
        while (!enemyHasLost()){
            turn = getTurn();
            if (turn % 2 != 0){
                playRound(firstPlayer, secondPlayer);
            }else{
                playRound(secondPlayer, firstPlayer);
            }
            setTurn(turn+1);
        }
    }

    private void playRound(Player currentPlayer, Player enemyPlayer){
        board.getTable(enemyPlayer);
        display.printEnemyTable();
        int [] shoot = inputs.cooInput();
        int xCord = shoot[0];
        int yCord = shoot[1];
        if (player.shoot(enemyPlayer, xCord, yCord, board)){
            display.targetHit();
        }else{
            display.miss();
        }
        board.setTable(enemyPlayer);
        display.printEnemyTable();
        if (enemyHasLost(enemyPlayer)){
            display.printResult();
        }
    }

    private boolean enemyHasLost(Player enemyPlayer){
        for (i=0; i<board.length; i++){
            for (j=0; j<board[i].length; j++){
                if (board[i][j] == enemyPlayer) {
                    return false;
                }
            }
        }
    return true;
    }
}
