package com.cryotech;

import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        RunawayConnect robot = new RunawayConnect();
        RunawaySolver solver = new RunawaySolver();

        try {
            HashMap<String, String> vars = robot.getBoardData();

            System.out.println(robot.trySolution("DR"));

            for(String a : solver.formTerrain(vars))
                System.out.println(a);

            System.out.println();

            System.out.println(vars.get("Terrain"));
            System.out.println(vars.get("InstructionsMax"));
            System.out.println(vars.get("InstructionsMin"));
            System.out.println(vars.get("BoardX"));
            System.out.println(vars.get("Level"));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
