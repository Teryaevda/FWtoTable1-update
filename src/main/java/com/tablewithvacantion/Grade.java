package com.tablewithvacantion;

import java.util.HashMap;

public class Grade implements Parametrs {

    public static final HashMap<Integer, String> MAP_GRADE = new HashMap();

    static {
        MAP_GRADE.put(0, "-");
        MAP_GRADE.put(1, "Junior");
        MAP_GRADE.put(2, "Middle");
        MAP_GRADE.put(3, "Senior");
        MAP_GRADE.put(4, "K1");
        MAP_GRADE.put(5, "K2");
        MAP_GRADE.put(6, "K3");
        MAP_GRADE.put(7, "K4");
        MAP_GRADE.put(8, "K5");
    }
    public static String getParametrs(Integer numOfExpirience){
        if (MAP_GRADE.get(numOfExpirience) == null) {
            return "-";
        }
        return MAP_GRADE.get(numOfExpirience);
    }
}
