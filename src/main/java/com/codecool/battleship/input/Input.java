package com.codecool.battleship.input;

import com.codecool.battleship.Util;

import java.util.Scanner;

public class Input {

    Scanner userInput = new Scanner(System.in);

    public int userInt() {
        String input = "";
        while (!isInt(input)) {
            input = userInput.nextLine();
        }
        return Integer.parseInt(input);
    }

    private boolean isInt(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (
                NumberFormatException e) {
            return false;
        }
    }

    public int [] userCoo(){
        char[] abc = Util.getLetters(10, false);
        String move = userInput.nextLine();
        char [] startingCord = move.toCharArray();
        if (!isValidCooInput(startingCord)){
            //wrong input message
            return userCoo();
        }
        int firstCoo = convertFirstCord(startingCord[0], abc);
        int secCoo = convertSecondCord(startingCord, abc);
        if (firstCoo<0 || secCoo<0){
            //wrong input message
            return userCoo();
        }
        int[] startingCoo = new int[2];
        startingCoo[0] = firstCoo;
        startingCoo[1] = secCoo;
        return startingCoo;
    }

    public int convertFirstCord(char cord, char[] abc){
        int firstCord = 0;
        boolean found = false;
        for (int i=0; i< abc.length; i++){
            if (abc[i] == cord){
                firstCord = i;
                found = true;
            }
        }
        if (found){
            return firstCord;
        }
        return -1;
    }


    public int convertSecondCord(char [] cords, char[] abc){
        String convertCord;
        if (cords.length >2){
            convertCord = String.valueOf(cords[1]) + cords[2];
        }else{
            convertCord = String.valueOf(cords[1]);
        }
        int coo = Integer.parseInt(convertCord)-1;
        if (coo<abc.length){
            return coo;
        }
        return -1;
    }

    public boolean isValidCooInput(char [] coords){
        if (coords.length<2 || coords.length>3){
            return false;
        }else if (coords.length == 3){
            return Character.isDigit(coords[1]) && Character.isDigit(coords[2]);
        }else return Character.isDigit(coords[1]);
    }
}