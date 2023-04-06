package com.microservises.ServiseRegistry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ServiseRegistryApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiseRegistryApplication.class, args);
	}

}
