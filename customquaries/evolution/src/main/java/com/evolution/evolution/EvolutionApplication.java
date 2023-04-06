package com.evolution.evolution;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootApplication
public class EvolutionApplication {

	public static void main(String[] args) {
		SpringApplication.run(EvolutionApplication.class, args);
	}

	public Map<Integer, LinkedHashMap<String, Object>> getUsers() throws Exception {
		// create a web client to send HTTP requests
		WebClient webClient = WebClient.builder()
				.baseUrl("https://jsonplaceholder.typicode.com")
				.clientConnector(new ReactorClientHttpConnector())
				.build();

		// send a GET request to the /users endpoint with the APPLICATION.JSON header
		List<LinkedHashMap<String, Object>> response = webClient.get()
				.uri("/users")
				.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
				.retrieve()
				.bodyToMono(new TypeReference<List<LinkedHashMap<String, Object>>>() {})
				.block();

		// create a LinkedHashMap to store the result
		Map<Integer, LinkedHashMap<String, Object>> result = new LinkedHashMap<>();

		// iterate over the list of JSONObjects and convert them to a LinkedHashMap
		for (LinkedHashMap<String, Object> user : response) {
			int id = (int) user.get("id");
			user.remove("id");
			result.put(id, user);
		}

		return result;
	}
}

}
