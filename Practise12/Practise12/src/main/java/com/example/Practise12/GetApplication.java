package com.example.Practise12;


import org.springframework.web.reactive.function.client.WebClient;

public class GetApplication {
    public static void main(String[] args) {
         String url="https://jsonplaceholder.typicode.com/users";


        String catFact= WebClient.create().get()

                .uri(url)
                .retrieve()
                .bodyToMono(String.class)
                .block();
        System.out.println(".....................");
        System.out.println(catFact);
        System.out.println(".....................");

    }
}
