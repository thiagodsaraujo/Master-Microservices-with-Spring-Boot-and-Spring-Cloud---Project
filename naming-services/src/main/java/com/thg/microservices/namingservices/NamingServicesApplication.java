package com.thg.microservices.namingservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class NamingServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(NamingServicesApplication.class, args);
	}

}
