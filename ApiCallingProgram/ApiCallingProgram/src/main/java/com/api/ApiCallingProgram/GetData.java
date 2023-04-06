package com.api.ApiCallingProgram;

import org.springframework.web.reactive.function.client.WebClient;

public class GetData {
    public static void main(String[] args) {
        String url="https://jsonplaceholder.typicode.com/users";

        WebClient.Builder builder=WebClient.builder();
        String catFact=builder.build()
                .get()
                .uri(url)
                .retrieve()
                .bodyToMono(String.class)
                .block();
        System.out.println(".....................");
        System.out.println(catFact);
        System.out.println(".....................");

    }
}



