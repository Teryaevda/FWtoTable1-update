package com.tablewithvacantion;

import com.tablewithvacantion.Parametrs;

import java.util.HashMap;

public class WorkFormat implements Parametrs {

    public static final HashMap<Integer, String> MAP_WORK_FORMAT = new HashMap();

    static {
        MAP_WORK_FORMAT.put(0, "-");
        MAP_WORK_FORMAT.put(1, "Офис");
        MAP_WORK_FORMAT.put(2, "Удаленная работа");
        MAP_WORK_FORMAT.put(3, "Гибрид");
    }
    public static String getParametrs(Integer numOfWorkFormat){
        if (MAP_WORK_FORMAT.get(numOfWorkFormat) == null) {
            return "-";
        }
        return MAP_WORK_FORMAT.get(numOfWorkFormat);
    }
}
