package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class PrepareData {

    public static Map<String, String> getDataFromFile(Path path) throws IOException {
        List<String> stringListDataFromFile = Files.readAllLines(path);
        Map<String, String> mapDataFromFromFile = new HashMap<>();

        stringListDataFromFile.forEach(element ->
                mapDataFromFromFile.put((element.substring(0, element.indexOf("=")).trim()), (element.substring(element.indexOf("=") + 1).trim())));
        return mapDataFromFromFile;
    }

    public static List<String> getKeysFromMap(Map<String, String> mapData) {
        List<String> keysList = new ArrayList<>();
        mapData.forEach((key, value) -> keysList.add(key));
        return keysList;
    }

    public static String[] getThreeRandomKeysArray(List<String> keysList) {
        Random random = new Random();
        return new String[]{keysList.get(random.nextInt(keysList.size())), keysList.get(random.nextInt(keysList.size())), keysList.get(random.nextInt(keysList.size()))};
    }
}
