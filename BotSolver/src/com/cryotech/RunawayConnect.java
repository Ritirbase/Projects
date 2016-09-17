package com.cryotech;

import java.net.*;
import java.io.*;
import java.util.regex.*;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Cryotech on 9/8/2016.
 */
public class RunawayConnect {
    private HashMap<String, String> m_board;

    public RunawayConnect() {
        m_board = new HashMap<>();
    }

    public ArrayList<String> regexFind(String input, String pattern) {

        ArrayList<String> searchOutput = new ArrayList<>();
        Pattern searchPattern = Pattern.compile(pattern);
        Matcher searchMatcher = searchPattern.matcher(input);

        while (searchMatcher.find()) {
            searchOutput.add(searchMatcher.group(0));
        }
        return searchOutput;
    }

    public HashMap<String, String> getBoardData() throws Exception {

        URL site = new URL("http://www.hacker.org/runaway/index.php/?name=Amadeus&password=tokencat321");
        BufferedReader buf = new BufferedReader(new InputStreamReader(site.openStream()));

        String vars = null;
        while (buf.ready()) {
            String read = buf.readLine();
            if (!regexFind(read, "(?<=FlashVars=\")([a-zA-Z0-9.=&]+)(?=\")").isEmpty()) {
                vars = regexFind(read, "(?<=FlashVars=\")([a-zA-Z0-9.=&]+)(?=\")").get(0);
            }
            if (vars != null) break;
        }
        ArrayList<String> varValues = regexFind(vars, "(?<==|&)([a-zA-Z0-9.]+)(?=&|$)");

        m_board.put("Terrain", varValues.get(0));
        m_board.put("InstructionsMax", varValues.get(1));
        m_board.put("InstructionsMin", varValues.get(2));
        m_board.put("BoardX", varValues.get(3));
        m_board.put("Level", varValues.get(5));

        buf.close();
        return m_board;
    }

    public boolean trySolution(String solution) throws Exception {

        URL site = new URL("http://www.hacker.org/runaway/index.php/?name=Amadeus&password=tokencat321&path=" + solution);
        BufferedReader buf = new BufferedReader(new InputStreamReader(site.openStream()));

        boolean returnval = false;

        if (buf.ready()) {
            String read = buf.readLine();
            if (!read.contains("boom")) returnval = true;
        }

        buf.close();
        return returnval;
    }
}
