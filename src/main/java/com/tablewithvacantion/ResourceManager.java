package com.tablewithvacantion;

import java.util.HashMap;

public class ResourceManager implements Parametrs {

    public static final HashMap<Integer, String> MAP_RESOURCE_MANAGER = new HashMap();

    static {
        MAP_RESOURCE_MANAGER.put(0, "-");
        MAP_RESOURCE_MANAGER.put(1, "Марченко Ирина \nТГ: @abuzinaa");
        MAP_RESOURCE_MANAGER.put(4, "Лыцусь Кристина");
        MAP_RESOURCE_MANAGER.put(2, "Кузнецова Алена \nТГ: @alenka_smith_TF");
        MAP_RESOURCE_MANAGER.put(3, "Пауткина Татьяна \nТГ: @TPautkina_TeamForce");
        MAP_RESOURCE_MANAGER.put(5, "Теряев Дмитрий");
        MAP_RESOURCE_MANAGER.put(6, "Иванова Анна");
        MAP_RESOURCE_MANAGER.put(7, "Садикова Александра");
        MAP_RESOURCE_MANAGER.put(8, "Гайнанова Роза");
    }
    public static String getParametrs(Integer numResourceManager){
        if (MAP_RESOURCE_MANAGER.get(numResourceManager) == null) {
            return "-";
        }
        return MAP_RESOURCE_MANAGER.get(numResourceManager);
    }
}

