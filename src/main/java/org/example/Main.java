package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        Map<String, String> properties = new HashMap();
        properties.put("login", "Angelina");
        properties.put("password", "angelinaInHollywood123");
        properties.put("title", "Salt");
        properties.put("url", "www.angelina.hollywood");
        properties.put("errorMessage", "file has not been founded");

        String[] sensualKeys = {"login", "password", "url"};

        Anonymization.anonymizationSensitiveData(properties, sensualKeys);

//        Poniżej wariant dla danych z pliku properties oraz randomowych kluczy

        Random random = new Random();
        Path path = Paths.get("src/main/resources/data.properties");
        List<String> stringListDataFromFile = Files.readAllLines(path);
        Map<String, String> mapDataFromFromFile = new HashMap<>();

        stringListDataFromFile.forEach(element -> {
            mapDataFromFromFile.put((element.substring(0, element.indexOf("=")).trim()), (element.substring(element.indexOf("=") + 1).trim()));
        });

        List<String> keysList = new ArrayList<>();
        mapDataFromFromFile.forEach((key, value) -> {
            keysList.add(key);
        });

        String[] testArray = {keysList.get(random.nextInt(keysList.size())), keysList.get(random.nextInt(keysList.size())), keysList.get(random.nextInt(keysList.size()))};

        System.out.println("++++++++++++++++++++");
        Anonymization.anonymizationSensitiveData(mapDataFromFromFile, testArray);
    }
}