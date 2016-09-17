package com.cryotech;

import java.util.Random;
import java.lang.Math;

/**
 * Created by Cryotech on 9/9/2016.
 */
public class TicTacTutorial {

    private static String[] formTerrain(String data, Integer x) {
        String[] map = new String[x];
        for (int i = 0; i < data.length(); i += x) {
            map[i / x] = data.substring(i, i + x);
        }
        return map;
    }

    public String generateBoard(String user, String level) {

        if (user == null || level == null) return null; // Return null if user or level do not exist
        if (user.length() == 0 || level.length() == 0) return null; // Return null if strings are empty
        if (Integer.valueOf(level) < 0) return null; // Return null if level is negative

        Integer xdim = 3 + Math.floorDiv(Integer.valueOf(level), 10); // Dimension of board

        Integer uservalue = Integer.valueOf(level);
        StringBuilder str = new StringBuilder((int) Math.pow(xdim, 2)); // String to hold board
        StringBuilder vfy = new StringBuilder((int) Math.pow(xdim, 2)); // String to send to verification function

        for (int i = 0; i < str.capacity(); ++i) { // Fill string with '.'
            str.append('.');
            vfy.append('.');
        }

        for (Character a : user.toCharArray()) // Add level and numeric username values together to create unique seed
            uservalue += Integer.valueOf(a); // i.e. user: "Abc" lv: 10, 'A' = 65, 'b' = 98, 'c' = 99, seed: 272

        Random random = new Random(Long.valueOf(uservalue)); // Random integer generator seeded with uservalue

        for (int i = 0; i < xdim; ) {
            int index = random.nextInt((int) Math.pow(xdim, 2));

            if (str.charAt(index) == 'O') continue;

            str.setCharAt(index, 'O'); // Fill board with 'O' in unique, random places
            vfy.setCharAt(index, 'X'); // Fill verification string with 'X' in same places
            ++i;
        }
        return verifySolution(".........", vfy.toString()) ? // Return board data if 'O' didn't win, else re-generate
                generateBoard(String.valueOf(user + random.nextInt(10)), level) : str.toString();
    }

    public static String[] toCubic(String a) {

        if (a == null || a.length() == 0) return new String[0]; // Return null String if board doesn't exist
        if (Math.sqrt(a.length()) % 1 != 0) return new String[0]; // Return null String if board is not cubic

        return formTerrain(a, (int) Math.sqrt(a.length()));
    }

    public Boolean verifySolution(String user, String level, String solution) {

        return verifySolution(generateBoard(user, level), solution);
    }

    private Boolean verifySolution(String board, String solution) {

        if (board == null || solution == null) return false; // Return false if board or solution doesn't exist
        if (board.length() == 0 || solution.length() == 0) return false; // Return false if strings are empty
        if (solution.length() != board.length()) return false; // Return false if solution is not same size as board
        if (Math.sqrt(board.length()) % 1 != 0) return false; // Return false if board is not cubic

        Integer xdim = (int) Math.sqrt(board.length());
        Integer mask = 0;

        Integer value = 0;
        for (int i = 0; i < solution.length(); ++i) {
            value <<= 1;
            if (solution.charAt(i) == 'X' && board.charAt(i) != 'O')
                value ^= 1;
        }

        // e.g. xdim = 3 : mask = 000 000 111
        for (int i = 0; i < xdim; ++i) {
            mask <<= 1;
            mask ^= 1;
        }

        // e.g. xdim = 3
        // 1. 000 000 111    1. ...    2. ...    3. XXX
        // 2. 000 111 000       ...       XXX       ...
        // 3. 111 000 000       XXX       ...       ...
        for (int i = 0; i < xdim; ++i) {
            if ((mask ^ value) == 0) return true;
            mask <<= xdim;
        }

        // e.g. xdim = 3 : mask = 001 001 001
        mask = 1;
        for (int i = 0; i < xdim - 1; ++i) {
            mask <<= xdim;
            mask ^= 1;
        }

        // e.g. xdim = 3
        // 1. 001 001 001    1. ..X    2. .X.    3. X..
        // 2. 010 010 010       ..X       .X.       X..
        // 3. 100 100 100       ..X       .X.       X..
        for (int i = 0; i < xdim; ++i) {
            if ((mask ^ value) == 0) return true;
            mask <<= 1;
        }

        // e.g. xdim = 3 : mask = 001 010 100
        mask = 1;
        for (int i = 0; i < xdim - 1; ++i) {
            mask <<= xdim - 1;
            mask ^= 1;
        }
        mask <<= xdim - 1;

        // e.g. xdim = 3
        // 1. 001 010 100    1. ..X
        //                      .X.
        //                      X..
        if ((mask ^ value) == 0) return true;

        // e.g. xdim = 3 : mask = 100 010 001
        mask = 1;
        for (int i = 0; i < xdim - 1; ++i) {
            mask <<= xdim + 1;
            mask ^= 1;
        }

        // e.g. xdim = 3
        // 1. 100 010 001    1. X..
        //                      .X.
        //                      ..X
        return (mask ^ value) == 0;
    }
}
