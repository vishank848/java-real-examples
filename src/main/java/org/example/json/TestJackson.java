package org.example.json;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

public class TestJackson {

    public static void main(String[] args) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        String testJson = "{\n" + "  \"user\": {\n" + "    \"0\": {\n" + "      \"firstName\": \"Monica\",\n" + "      \"lastName\": \"Belluci\"\n" + "    },\n" + "    \"1\": {\n" + "      \"firstName\": \"John\",\n" + "      \"lastName\": \"Smith\"\n" + "    },\n" + "    \"2\": {\n" + "      \"firstName\": \"Owen\",\n" + "      \"lastName\": \"Hargreaves\"\n" + "    }\n" + "  }\n" + "}";
        User readValue = mapper.readValue(testJson, User.class);
        System.out.println("readValue = " + readValue);
    }

    @Setter
    @Getter
    @ToString
    static class User {
        private Map<String, MyObject> user = new HashMap<>();
    }

    @Setter
    @Getter
    @ToString
    static class MyObject {
        private String firstName;
        private String lastName;
    }
}
