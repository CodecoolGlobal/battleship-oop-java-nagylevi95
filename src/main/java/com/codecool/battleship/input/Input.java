package com.codecool.battleship.input;

import com.codecool.battleship.Util;

import java.util.Scanner;

public class Input {

    Scanner userInput = new Scanner(System.in);

    public int userInt() {
        String input = "";
        while (isInt(input)) {
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

}
