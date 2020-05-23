package com.myproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties
@SpringBootApplication
public class SpringBootMyProject01Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMyProject01Application.class, args);
	}

}
