package com.example.Practise12;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
public class HomeController {

    @GetMapping("/get")
    public Object  getData(@RequestParam("id") String id) throws JsonProcessingException {
        String json = WebClient.create("https://jsonplaceholder.typicode.com/users").method(HttpMethod.GET).header(MediaType.APPLICATION_JSON_VALUE).retrieve().bodyToMono(String.class).block();
        Gson gson = new Gson();
        System.out.println(id);

        JsonObject jsonObject2 = null;

        JsonParser parser = new JsonParser();
        JsonArray jsonArray = parser.parse(json).getAsJsonArray();
        for(JsonElement obj : jsonArray){
            JsonObject id1 = obj.getAsJsonObject();
            String id2= id1.get("id").toString();
            if(id2.equalsIgnoreCase(id)){
                jsonObject2= id1;
            }
        }

        return  jsonObject2.toString();
    }

}
