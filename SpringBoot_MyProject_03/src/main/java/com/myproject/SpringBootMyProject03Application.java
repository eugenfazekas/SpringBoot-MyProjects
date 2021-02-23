package com.myproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties
@SpringBootApplication
public class SpringBootMyProject03Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMyProject03Application.class, args);
	}

}
