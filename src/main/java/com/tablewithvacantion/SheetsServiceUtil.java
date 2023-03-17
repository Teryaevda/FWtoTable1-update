package com.tablewithvacantion;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.model.ClearValuesRequest;
import com.google.api.services.sheets.v4.model.ClearValuesResponse;
import com.google.api.services.sheets.v4.model.UpdateValuesResponse;
import com.google.api.services.sheets.v4.model.ValueRange;
import com.tablewithvacantion.GoogleAuthorizeUtil;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;
// класс работы с гуглшитами/
public class SheetsServiceUtil {

    private static final String APPLICATION_NAME = "TableWithVacantionApp";
// создает авторизацию
    public static Sheets getSheetsService() throws IOException, GeneralSecurityException {
        Credential credential = GoogleAuthorizeUtil.authorize();
        return new Sheets.Builder(GoogleNetHttpTransport.newTrustedTransport(), JacksonFactory.getDefaultInstance(), credential).setApplicationName(APPLICATION_NAME).build();
    }

        private static Sheets sheetsService;
        private static final String SPREADSHEET_ID = "1Tp10m32jJywD8_L2s2gqapcobvUOLxBpNyyevUQsAh0"; // ссылка на гуглтаблицу

// создает сервис для работы с гуглшитом
        public static void setup() throws GeneralSecurityException, IOException {
            sheetsService = SheetsServiceUtil.getSheetsService();
        }
// очищает и записывает заного гугл таблицу
    public void clearSheetAndWriteSheet(List<List<Object>> listOfVacantion) throws IOException {
        ValueRange body = new ValueRange();
        ClearValuesResponse resultClear = sheetsService.spreadsheets().values().clear(SPREADSHEET_ID, "A2:FT",new ClearValuesRequest()).execute();
        UpdateValuesResponse result = sheetsService.spreadsheets().values()
                .update(SPREADSHEET_ID, "A2", body.setValues(listOfVacantion))
                .setValueInputOption("RAW")
                .execute();
    }
}