package com.example.Practise12;
import com.google.gson.*;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.LinkedHashMap;
import java.util.Map;
public class Sample {

    public static void main(String[] args) throws Exception {
        String url = "https://jsonplaceholder.typicode.com/users";
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Content-Type", "application/json")
                .GET()
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        String responseBody = response.body();

        // Convert the JSON response to a LinkedHashMap with the user ID as the key
        Map<Integer, Map<String, Object>> usersMap = new LinkedHashMap<>();
        JsonArray jsonArray = JsonParser.parseString(responseBody).getAsJsonArray();
        for (JsonElement element : jsonArray) {
            JsonObject jsonObject = element.getAsJsonObject();
            int id = jsonObject.get("id").getAsInt();
            jsonObject.remove("id");
            Map<String, Object> userMap = new Gson().fromJson(jsonObject, LinkedHashMap.class);
            usersMap.put(id, userMap);
        }
        // Print the LinkedHashMap
        System.out.println(usersMap);
    }
}

