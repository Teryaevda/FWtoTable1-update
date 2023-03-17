package com.tablewithvacantion;

import java.util.HashMap;

public class Expirience implements Parametrs {

    public static final HashMap<Integer, String> MAP_EXPIRIENCE = new HashMap();

    static {
        MAP_EXPIRIENCE.put(0, "-");
        MAP_EXPIRIENCE.put(1, "До 3 лет");
        MAP_EXPIRIENCE.put(2, "От 3 до 5 лет");
        MAP_EXPIRIENCE.put(3, "От 5 лет");
    }
    public static String getParametrs(Integer numOfCategory){
        if (MAP_EXPIRIENCE.get(numOfCategory) == null) {
            return "-";
        }
        return MAP_EXPIRIENCE.get(numOfCategory);
    }
}

