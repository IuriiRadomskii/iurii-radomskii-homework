package com.epam.tc.hw7.data;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;
import java.util.stream.Collectors;

public class JsonParser {

    private static final ObjectMapper mapper = new ObjectMapper();
    private static final String json = getJSonFromFile();
    private static final String JSON = "src/test/resources/com.epam.tc.hw7.data/JDI_ex8_metalsColorsDataSet.json";

    private static String getJSonFromFile() {
        String json = null;
        try {
            json = Files.readString(
                Path.of(JSON));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return json;
    }

    public static Object[][] getTestData() {
        Object[][] testData = null;
        try {
            testData = mapper
                .readValue(json, new TypeReference<Map<String, Info>>() {})
                .values().stream()
                .map(info -> new Object[] {info})
                .collect(Collectors.toList())
                .toArray(new Object[][]{});
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return testData;
    }
}
    /*JsonNode node = mapper.readTree(json).get("data_1");
    String strNode = node.toString();
    Info info = mapper.readValue(strNode, Info.class);
    System.out.println(info);*/
