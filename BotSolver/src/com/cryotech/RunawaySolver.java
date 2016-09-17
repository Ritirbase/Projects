package com.cryotech;

import java.util.HashMap;

/**
 * Created by Cryotech on 9/8/2016.
 */
public class RunawaySolver {

    public String[] formTerrain(HashMap<String, String> data) {
        String[] map = new String[Integer.valueOf(data.get("BoardX"))];
        for(int i = 0; i < data.get("Terrain").length(); i += Integer.valueOf(data.get("BoardX"))) {
           map[i / Integer.valueOf(data.get("BoardX"))] =
                   data.get("Terrain").substring(i, i + Integer.valueOf(data.get("BoardX")));
        }
        return map;
    }

}
