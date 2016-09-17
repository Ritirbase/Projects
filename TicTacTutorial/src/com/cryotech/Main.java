package com.cryotech;

public class Main {

    public static void main(String[] args) {

        if (args.length >= 3) {
            TicTacTutorial gen = new TicTacTutorial();

            String action = args[0];
            String user = args[1];
            String level = args[2];

            if (args.length == 3 && action.equals("generate")) { // Generate
                System.out.print(gen.generateBoard(user, level));

            } else if (args.length == 4 && action.equals("verify")) { // Verify
                String solution = args[3];
                System.out.print(gen.verifySolution(user, level, solution));
            }
        }
        //test();
    }

    private static void test() {

        TicTacTutorial gen = new TicTacTutorial();

        String testlevel = "11";
        String str = gen.generateBoard("abc", testlevel);

        /*
        String test = "abcabcabc";
        if (TicTacTutorial.toCubic(test).length == 0)
            System.out.println("Empty!\n");
        else
            System.out.println("Not empty!\n");

        System.out.println("Cubic");
        for (String a : TicTacTutorial.toCubic("......XXX"))
            System.out.println(a);

        System.out.println();
        for (String a : TicTacTutorial.toCubic("..X.X.X.."))
            System.out.println(a);

        for (String a : TicTacTutorial.toCubic("..X"))
            System.out.println(a);

        System.out.println();
        for (String a : TicTacTutorial.toCubic("..........XXXXX.........."))
            System.out.println(a);
        */

        System.out.println("\nTo solve:");

        for (String a : TicTacTutorial.toCubic(str))
            System.out.println(a);

        System.out.println("\nSolutions:");

        if (gen.verifySolution("abc", testlevel, "XXX......")) {
            for (String a : TicTacTutorial.toCubic("XXX......")) System.out.println(a);
            System.out.println();
        }
        if (gen.verifySolution("abc", testlevel, "...XXX...")) {
            for (String a : TicTacTutorial.toCubic("...XXX...")) System.out.println(a);
            System.out.println();
        }
        if (gen.verifySolution("abc", testlevel, "......XXX")) {
            for (String a : TicTacTutorial.toCubic("......XXX")) System.out.println(a);
            System.out.println();
        }
        if (gen.verifySolution("abc", testlevel, "X..X..X..")) {
            for (String a : TicTacTutorial.toCubic("X..X..X..")) System.out.println(a);
            System.out.println();
        }
        if (gen.verifySolution("abc", testlevel, ".X..X..X.")) {
            for (String a : TicTacTutorial.toCubic(".X..X..X.")) System.out.println(a);
            System.out.println();
        }
        if (gen.verifySolution("abc", testlevel, "..X..X..X")) {
            for (String a : TicTacTutorial.toCubic("..X..X..X")) System.out.println(a);
            System.out.println();
        }
        if (gen.verifySolution("abc", testlevel, "X...X...X")) {
            for (String a : TicTacTutorial.toCubic("X...X...X")) System.out.println(a);
            System.out.println();
        }
        if (gen.verifySolution("abc", testlevel, "..X.X.X..")) {
            for (String a : TicTacTutorial.toCubic("..X.X.X..")) System.out.println(a);
            System.out.println();
        }

        if (gen.verifySolution("abc", testlevel, "XXXX............")) {
            for (String a : TicTacTutorial.toCubic("XXXX............")) System.out.println(a);
            System.out.println();
        }
        if (gen.verifySolution("abc", testlevel, "....XXXX........")) {
            for (String a : TicTacTutorial.toCubic("....XXXX........")) System.out.println(a);
            System.out.println();
        }
        if (gen.verifySolution("abc", testlevel, "........XXXX....")) {
            for (String a : TicTacTutorial.toCubic("........XXXX....")) System.out.println(a);
            System.out.println();
        }
        if (gen.verifySolution("abc", testlevel, "............XXXX")) {
            for (String a : TicTacTutorial.toCubic("............XXXX")) System.out.println(a);
            System.out.println();
        }
        if (gen.verifySolution("abc", testlevel, "X...X...X...X...")) {
            for (String a : TicTacTutorial.toCubic("X...X...X...X...")) System.out.println(a);
            System.out.println();
        }
        if (gen.verifySolution("abc", testlevel, ".X...X...X...X..")) {
            for (String a : TicTacTutorial.toCubic(".X...X...X...X..")) System.out.println(a);
            System.out.println();
        }
        if (gen.verifySolution("abc", testlevel, "..X...X...X...X.")) {
            for (String a : TicTacTutorial.toCubic("..X...X...X...X.")) System.out.println(a);
            System.out.println();
        }
        if (gen.verifySolution("abc", testlevel, "...X...X...X...X")) {
            for (String a : TicTacTutorial.toCubic("...X...X...X...X")) System.out.println(a);
            System.out.println();
        }
        if (gen.verifySolution("abc", testlevel, "X....X....X....X")) {
            for (String a : TicTacTutorial.toCubic("X....X....X....X")) System.out.println(a);
            System.out.println();
        }
        if (gen.verifySolution("abc", testlevel, "...X..X..X..X...")) {
            for (String a : TicTacTutorial.toCubic("...X..X..X..X...")) System.out.println(a);
            System.out.println();
        }
    }
}