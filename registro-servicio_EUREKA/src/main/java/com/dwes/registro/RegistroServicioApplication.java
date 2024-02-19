package com.dwes.registro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class RegistroServicioApplication {

	public static void main(String[] args) {
		SpringApplication.run(RegistroServicioApplication.class, args);
	}

}
