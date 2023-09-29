package com.tablewithvacantion;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/*
Класс создает подключение к апи фриендворка, забирает токен авторизации и обеспечивают работу
*/
public class HttpClient {
    List<List<Object>> listOfVacantion = new ArrayList<>();

    public void httpGenerationVacantion(String filter ) throws IOException {

        CloseableHttpClient httpClient = HttpClients.createDefault();
        try {
            // создаем объект клиента
            HttpGet request = new HttpGet("https://app.friend.work/api/Accounts/LogIn?username=d.teryaev@teamforce.ru&password=Pallas123_");
            CloseableHttpResponse response = httpClient.execute(request);
            try {
                // статус ответа
                System.out.println(response.getProtocolVersion());              // HTTP/1.1
                System.out.println(response.getStatusLine().getStatusCode());   // 200
                System.out.println(response.getStatusLine().getReasonPhrase()); // OK
                System.out.println(response.getStatusLine().toString());        // HTTP/1.1 200 OK

                HttpEntity entity = response.getEntity();
                String jwt = null;
                // если есть тело ответа
                if (entity != null) {
                    // возвращаем строку
                    jwt = EntityUtils.toString(entity);
                    System.out.println(jwt);
                }
//парсим jwt через json
                Object obj = new JSONParser().parse(jwt);
// Кастим obj в JSONObject
                JSONObject jo = (JSONObject) obj;
// Достаём токен
                String jwtToken = (String) jo.get("jwtToken");
                System.out.println(jwtToken);
// Пост запрос к апи фриендворка, который возвращает JSON с вакансиями по фильтру
                HttpPost request1 = new HttpPost("https://app.friend.work/api/Jobs/ByFilter");
                System.out.println("Фильтрздесь " + filter);
// Добавляет параметры к пост запросу согласно апи для нужного филтра
                StringEntity stringEntity = new StringEntity(filter);
                request1.setEntity(stringEntity);
//доавляет в хедер тип запроса и токен авторизации
                request1.addHeader("Content-Type", "application/json");
                request1.addHeader("Authorization","Bearer " + jwtToken);

// Получение ответа от апи и парсинг JSON
                CloseableHttpResponse response1 = httpClient.execute(request1);
                System.out.println(response1.getProtocolVersion());              // HTTP/1.1
                System.out.println(response1.getStatusLine().getStatusCode());   // 200
                System.out.println(response1.getStatusLine().getReasonPhrase()); // OK
                System.out.println(response1.getStatusLine().toString());
                HttpEntity entity1 = response1.getEntity();
                String strJson = null;

                strJson = EntityUtils.toString(entity1);

                Object obj1 = new JSONParser().parse(strJson);
                System.out.println(obj1);
// Кастим obj в JSONObject
                JSONObject jo1 = (JSONObject) obj1;

                //String js = (String) jo.get("items");

/* разбор JSON и создание объектов по классам.
 После окончания циклов помещает полученные данные по вакансии в лист listOfAllFieldVacantion,
 listOfAllFieldVacantion в listOfVacantion для передачи в метод clearSheetAndWriteSheet класса SheetsServiceUtil
 */
                JSONArray jsonArray = (JSONArray) jo1.get("items");
                Iterator itemItr = jsonArray.iterator();

                while (itemItr.hasNext()) {
                    Vacantion vacantion = new Vacantion();
                    List<Object> listOfAllFieldVacantion = new ArrayList<>();
                    JSONObject jsonObjectForItemItr = (JSONObject) itemItr.next();
                    vacantion.setNameOfVacantion(jsonObjectForItemItr.get("name"));
                    System.out.println("- название: "+ vacantion.getNameOfVacantion());
                    vacantion.setIdVacantion(jsonObjectForItemItr.get("jobId"));
                    System.out.println("- ID: " + vacantion.getIdVacantion());
                    vacantion.setDescriptionOfVacantion(jsonObjectForItemItr.get("description"));
                    System.out.println("- описание: " + vacantion.getDescriptionOfVacantion());
                    vacantion.setCommentToVacantion(jsonObjectForItemItr.get("comment"));
                    System.out.println("- комментарии: " + vacantion.getCommentToVacantion());
                    vacantion.setCategoryOfVacanion(jsonObjectForItemItr.get("jobTypeId"));
                    System.out.println("- Категория: " + vacantion.getCategoryOfVacanion());
                    JSONArray jsonArrayCustomFieldsValues = (JSONArray) jsonObjectForItemItr.get("customFieldsValues");
                    Iterator customFieldsValuesItr = jsonArrayCustomFieldsValues.iterator();
                    while (customFieldsValuesItr.hasNext()){
                        JSONObject jsonObjectForCustomFieldsValuesItr = (JSONObject) customFieldsValuesItr.next();
                        if (jsonObjectForCustomFieldsValuesItr.get("systemName").equals("TeamForce_Project")){
                            vacantion.setProject(jsonObjectForCustomFieldsValuesItr.get("value"));
                            System.out.println("- Проект: " + vacantion.getProject());
                        } else if (jsonObjectForCustomFieldsValuesItr.get("systemName").equals("TeamForce_Requirements")){
                            vacantion.setRequirementsToVacantion(jsonObjectForCustomFieldsValuesItr.get("value"));
                            System.out.println("- Требования: " + vacantion.getRequirementsToVacantion());
                        } else if(jsonObjectForCustomFieldsValuesItr.get("systemName").equals("TeamForce_Role1111")){
                            vacantion.setStackOfVacantion(jsonObjectForCustomFieldsValuesItr.get("value"));
                            System.out.println("- Стек: " + vacantion.getStackOfVacantion());
                        } else if(jsonObjectForCustomFieldsValuesItr.get("systemName").equals("TeamForce_Grades")) {
                            vacantion.setGradeOfVacantion(jsonObjectForCustomFieldsValuesItr.get("value"));
                            System.out.println("- Грейд: " + vacantion.getGradeOfVacantion());
                        } else if(jsonObjectForCustomFieldsValuesItr.get("systemName").equals("TeamForce_Exp")) {
                            vacantion.setExpirienceOfVacantion(jsonObjectForCustomFieldsValuesItr.get("value"));
                            System.out.println("- Опыт: " + vacantion.getExpirienceOfVacantion());
                        } else if(jsonObjectForCustomFieldsValuesItr.get("systemName").equals("TeamForce_Address")) {
                            vacantion.setAddressOfVacantion(jsonObjectForCustomFieldsValuesItr.get("value"));
                            System.out.println("- Адресс: " + vacantion.getAddressOfVacantion());
                        } else if(jsonObjectForCustomFieldsValuesItr.get("systemName").equals("TeamForce_Format")) {
                            vacantion.setWorkFormatOfVacantion(jsonObjectForCustomFieldsValuesItr.get("value"));
                            System.out.println("- Формат работы: " + vacantion.getWorkFormatOfVacantion());
                        } else if(jsonObjectForCustomFieldsValuesItr.get("systemName").equals("TeamForce_Resource_manager")) {
                            System.out.println("- номер Ресурсного менеджера: " + jsonObjectForCustomFieldsValuesItr.get("value"));
                            vacantion.setResourceManagerOfVacantion(jsonObjectForCustomFieldsValuesItr.get("value"));
                            System.out.println("- Ресурсный менеджер: " + vacantion.getResourceManagerOfVacantion());
                        } else if(jsonObjectForCustomFieldsValuesItr.get("systemName").equals("TeamForce_Search_Geography")) {
                            vacantion.setGeographyOfVacantion(jsonObjectForCustomFieldsValuesItr.get("value"));
                            System.out.println("- Локация: " + vacantion.getGeographyOfVacantion());
                        }
                    }
                    System.out.println("----------------------------------------------------------------------");
                    listOfAllFieldVacantion.add(vacantion.getIdVacantion());
                    listOfAllFieldVacantion.add(vacantion.getCategoryOfVacanion());
                    listOfAllFieldVacantion.add(vacantion.getStackOfVacantion());
                    listOfAllFieldVacantion.add(vacantion.getGradeOfVacantion());
                   // listOfAllFieldVacantion.add(vacantion.getDescriptionOfVacantion()); Скрыл описание вакансии, чтобы не отображалось для партнеров
                    listOfAllFieldVacantion.add(vacantion.getProject());
                    listOfAllFieldVacantion.add(vacantion.getRequirementsToVacantion());
                    listOfAllFieldVacantion.add(vacantion.getExpirienceOfVacantion());
                    listOfAllFieldVacantion.add(vacantion.getAddressOfVacantion());
                    listOfAllFieldVacantion.add(vacantion.getGeographyOfVacantion());
                    listOfAllFieldVacantion.add(vacantion.getWorkFormatOfVacantion());
                    listOfAllFieldVacantion.add(vacantion.getResourceManagerOfVacantion());

                    listOfVacantion.add(listOfAllFieldVacantion);
                    System.out.println("Добавлена вакансия:********************************************** ");
                    System.out.println("Добавлеие закончено***********************************************");
                }
            } catch (ParseException e) {
                e.printStackTrace();
            } finally {
                response.close();
            }
        } finally {
            httpClient.close();
        }
    }

    public void clearlistOfVacantion(){
        listOfVacantion.clear();
    }

}
