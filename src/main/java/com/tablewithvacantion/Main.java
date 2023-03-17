package com.tablewithvacantion;

import com.tablewithvacantion.GoogleAuthorizeUtil;
import com.tablewithvacantion.HttpClient;

import java.io.IOException;
import java.security.GeneralSecurityException;

public class Main {
    public static void main(String[] args) {
        SheetsServiceUtil sheetsServiceUtil = new SheetsServiceUtil();
        int n = 0;
        try {
            SheetsServiceUtil.setup();
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        while (true) {
            try {

                HttpClient httpClient = new HttpClient();
                httpClient.httpGenerationVacantion();
                sheetsServiceUtil.clearSheetAndWriteSheet(httpClient.listOfVacantion);
            } catch (IOException e) {
                e.printStackTrace();
            }

            n = n + 1;
            System.out.println("Количество повторений:" + n);
            try {
                Thread.sleep(3600000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                GoogleAuthorizeUtil.authorize();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (GeneralSecurityException e) {
                e.printStackTrace();
            }
        }
    }
}
