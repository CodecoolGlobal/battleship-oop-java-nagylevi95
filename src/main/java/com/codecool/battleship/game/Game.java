package com.codecool.battleship.game;

import com.codecool.battleship.board.BoardFactory;
import com.codecool.battleship.display.Display;
import com.codecool.battleship.input.Input;
import com.codecool.battleship.player.Player;
import com.codecool.battleship.board.Board;
import com.codecool.battleship.square.Square;

public class Game {
    private Player firstPlayer;
    private Player secondPlayer;
    private final Display display = new Display();
    private final Input inputs = new Input();
    private Board player1Board;
    private Board player2Board;
    private int turn;
    private boolean hasWon;
    private String name;
    private final BoardFactory boardFactory = new BoardFactory();

    private int getTurn() {
        return turn;
    }

    private void setTurn(int turn) {
        this.turn = turn;
    }

    public Game() {
        hasWon = false;
        turn = 1;
    }

    public void newGame(){
        display.provideName();
        name = inputs.userName();
        firstPlayer = new Player(name);
        player1Board = new Board(10);
        placeBoard(firstPlayer, player1Board);
        display.provideName();
        name = inputs.userName();
        secondPlayer = new Player(name);
        player2Board = new Board(10);
        placeBoard(secondPlayer, player2Board);
        play();
    }

    private void play(){
        while (!hasWon){
            if (turn % 2 != 0){
                playRound(firstPlayer, secondPlayer, player2Board);
                if (secondPlayer.isAlive(secondPlayer.getShips())){
                    display.printWinner(firstPlayer.getName());
                    hasWon = true;
                }
            }else{
                playRound(secondPlayer, firstPlayer, player1Board);
                if (firstPlayer.isAlive(firstPlayer.getShips())){
                    display.printWinner(secondPlayer.getName());
                    hasWon = true;
                }
            }
            turn++;
        }
    }

    private void playRound(Player currentPlayer, Player enemyPlayer, Board board){
        board.display();
        int [] shoot = inputs.userCoo();
        int xCord = shoot[0];
        int yCord = shoot[1];
        /*if (board[xCord][yCord]. )
            currentPlayer.shoot(enemyPlayer, xCord, yCord, board);*/
        board.display();
    }

    private void placeBoard(Player player, Board board){
        display.placementSelection();
        int choice = inputs.userInt();
        switch (choice){
            case 1:
                boardFactory.manualPlacement(player, board);
                break;
            case 2:
                //boardfactory random;
                break;
            default:
                display.wrongInput();
                placeBoard(player, board);
        }
    }
}
