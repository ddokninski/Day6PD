package org.example;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {

        Map<String, String> properties = new HashMap<>();
        properties.put("login", "Angelina");
        properties.put("password", "angelinaInHollywood123");
        properties.put("title", "Salt");
        properties.put("url", "www.angelina.hollywood");
        properties.put("errorMessage", "file has not been founded");

        String[] sensualKeys = {"login", "password", "url"};

        Anonymization.anonymizationSensitiveData(properties, sensualKeys);

//        Poniżej wariant dla danych z pliku properties oraz randomowych kluczy

        Path path = Paths.get("src/main/resources/data.properties");
        Map<String, String> mapDataFromFile = PrepareData.getDataFromFile(path);
        List<String> keysFromMapList = PrepareData.getKeysFromMap(mapDataFromFile);
        String[] threeRandomKeysArray = PrepareData.getThreeRandomKeysArray(keysFromMapList);

        System.out.println("++++++++++++++++++++");

        Anonymization.anonymizationSensitiveData(mapDataFromFile, threeRandomKeysArray);
    }
}