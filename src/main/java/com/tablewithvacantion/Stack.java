package com.tablewithvacantion;

import java.util.HashMap;

public class Stack implements Parametrs {
    public static final HashMap<Integer, String> MAP_STACK = new HashMap();
    static {
        /*
        MAP_STACK.put(0, "-");
        MAP_STACK.put(1, "Администратор");
        MAP_STACK.put(2, "Аналитик");
        MAP_STACK.put(3, "Архитектор");
        MAP_STACK.put(4, "Бизнес Аналитик");
        MAP_STACK.put(5, "Дата инженер");
        MAP_STACK.put(6, "Дизайнер");
        MAP_STACK.put(7, "DevOps");
        MAP_STACK.put(8, "QA Auto");
        MAP_STACK.put(9, "QA Нагрузочное");
        MAP_STACK.put(10, "QA Функциональное");
        MAP_STACK.put(11, "Консультант SAP");
        MAP_STACK.put(12, "SAP ABAP");
        MAP_STACK.put(13, "ETL");
        MAP_STACK.put(14, "Full Stack");
        MAP_STACK.put(15, "Project Manager");
        MAP_STACK.put(16, "Системный аналитик");
        MAP_STACK.put(17, "QA Full Stack");
        MAP_STACK.put(18, "Data Science");
        MAP_STACK.put(19, "Android");
        MAP_STACK.put(20, "iOs");
        MAP_STACK.put(21, "Java");
        MAP_STACK.put(22, "Python");
        MAP_STACK.put(23, "Scala");
        MAP_STACK.put(24, "Oracle");
        MAP_STACK.put(25, "JavaScript");
        MAP_STACK.put(26, "React");
        MAP_STACK.put(27, "PHP");
        MAP_STACK.put(28, "Linux");
        MAP_STACK.put(29, "BI");
        MAP_STACK.put(30, "Qlick");
        MAP_STACK.put(31, "SAP BASIS");
        MAP_STACK.put(32, "SAP BW");
        MAP_STACK.put(33, "SAP CA");
        MAP_STACK.put(34, "SAP CO");
        MAP_STACK.put(35, "SAP FI");
        MAP_STACK.put(36, "SAP FS");
        MAP_STACK.put(37, "SAP HANA");
        MAP_STACK.put(38, "SAP IM");
        MAP_STACK.put(39, "SAP LE");
        MAP_STACK.put(40, "SAP LO");
        MAP_STACK.put(41, "SAP MDM");
        MAP_STACK.put(42, "SAP MM");
        MAP_STACK.put(43, "SAP PLM");
        MAP_STACK.put(44, "SAP PM");
        MAP_STACK.put(45, "SAP PO");
        MAP_STACK.put(46, "SAP PP");
        MAP_STACK.put(47, "SAP PS");
        MAP_STACK.put(48, "SAP QM");
        MAP_STACK.put(49, "SAP RCM");
        MAP_STACK.put(50, "SAP RE");
        MAP_STACK.put(51, "SAP SCM");
        MAP_STACK.put(52, "SAP SD");
        MAP_STACK.put(53, "SAP TOPO");
        MAP_STACK.put(54, "SAP TR");
        MAP_STACK.put(55, "SAP UI5");
        MAP_STACK.put(56, "SAP XI");
        MAP_STACK.put(57, "UX/UI");
        MAP_STACK.put(58, "C++");
        MAP_STACK.put(59, "C#");
        MAP_STACK.put(60, "Ruby");
        MAP_STACK.put(61, "1C");
        MAP_STACK.put(62, "Golang");
        MAP_STACK.put(63, "Scrum-мастер");
        MAP_STACK.put(64, "Database Developer");
        MAP_STACK.put(65, "Исследователь");

         */

        MAP_STACK.put(4089,"-");
        MAP_STACK.put(4090,"Администратор");
        MAP_STACK.put(4091,"Аналитик");
        MAP_STACK.put(4092,"Архитектор");
        MAP_STACK.put(4093,"Бизнес аналитик");
        MAP_STACK.put(4094,"Дата инженер");
        MAP_STACK.put(4095,"Дизайнер");
        MAP_STACK.put(4096,"DevOps");
        MAP_STACK.put(4097,"QA Авто");
        MAP_STACK.put(4098,"QA Нагрузочное");
        MAP_STACK.put(4099,"QA Функциональное");
        MAP_STACK.put(4100,"Консультант SAP");
        MAP_STACK.put(4101,"SAP ABAP");
        MAP_STACK.put(4102,"ETL");
        MAP_STACK.put(4103,"Full stack");
        MAP_STACK.put(4104,"Project manager");
        MAP_STACK.put(4105,"Системный аналитик");
        MAP_STACK.put(4106,"QA Full stack");
        MAP_STACK.put(4107,"DataScience");
        MAP_STACK.put(4108,"Android");
        MAP_STACK.put(4109,"IOS");
        MAP_STACK.put(4110,"Java");
        MAP_STACK.put(4111,"Python");
        MAP_STACK.put(4112,"Scala");
        MAP_STACK.put(4113,"Oracle");
        MAP_STACK.put(4114,"JavaScript");
        MAP_STACK.put(4115,"React");
        MAP_STACK.put(4116,"PHP");
        MAP_STACK.put(4117,"Linux");
        MAP_STACK.put(4118,"BI");
        MAP_STACK.put(4119,"Qlik");
        MAP_STACK.put(4120,"SAP Basis");
        MAP_STACK.put(4121,"SAP BW");
        MAP_STACK.put(4122,"SAP CA");
        MAP_STACK.put(4123,"SAP CO");
        MAP_STACK.put(4124,"SAP FI");
        MAP_STACK.put(4125,"SAP FS");
        MAP_STACK.put(4126,"SAP HANA");
        MAP_STACK.put(4127,"SAP IM");
        MAP_STACK.put(4128,"SAP LE");
        MAP_STACK.put(4129,"SAP LO");
        MAP_STACK.put(4130,"SAP MDM");
        MAP_STACK.put(4131,"SAP MM");
        MAP_STACK.put(4132,"SAP PLM");
        MAP_STACK.put(4133,"SAP PM");
        MAP_STACK.put(4134,"SAP PO");
        MAP_STACK.put(4135,"SAP PP");
        MAP_STACK.put(4136,"SAP PS");
        MAP_STACK.put(4137,"SAP QM");
        MAP_STACK.put(4138,"SAP RCM");
        MAP_STACK.put(4139,"SAP RE");
        MAP_STACK.put(4140,"SAP SCM");
        MAP_STACK.put(4141,"SAP SD");
        MAP_STACK.put(4142,"SAP TOPO");
        MAP_STACK.put(4143,"SAP TR");
        MAP_STACK.put(4144,"SAP UI5");
        MAP_STACK.put(4145,"SAP XI");
        MAP_STACK.put(4146,"UX/UI");
        MAP_STACK.put(4147,"C++");
        MAP_STACK.put(4148,"C#");
        MAP_STACK.put(4149,"Ruby");
        MAP_STACK.put(4150,"1С");
        MAP_STACK.put(4151,"Golang");
        MAP_STACK.put(4152,"Scrum -мастер");
        MAP_STACK.put(4153,"Database Developer");
        MAP_STACK.put(4154,"Исследователь");
        MAP_STACK.put(4155,"Web_JS");
        MAP_STACK.put(4156,"DWH");
        MAP_STACK.put(4157,"Flutter");
        MAP_STACK.put(4158,"node.JS");
        MAP_STACK.put(4192,"SQL");
        MAP_STACK.put(4191,"Angular");



    }
    public static String getParametrs(Integer numOfCategory){
        if (MAP_STACK.get(numOfCategory) == null) {
            return "-";
        }
        return MAP_STACK.get(numOfCategory);
    }
}