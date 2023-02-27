package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Anonymization {

    protected static void anonymizationSensitiveData(Map<String, String> map, String[] list) {
        List<String> sensualKeysList = new ArrayList<>(Arrays.asList(list));
        map.forEach((key, value) -> {
            System.out.println(key + " = " + (sensualKeysList.stream().anyMatch(sensitiveKey -> sensitiveKey.equals(key)) ? "*****" : value));
        });
    }
}
