package com.myproject.service.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Cronoweb_CommandLineRunner implements CommandLineRunner {

	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public void run(String... args) throws Exception {
		 try {

			    Path path = Paths.get("src/main/resources/static/img/imageUpload");

			    //java.nio.file.Files;
			    Files.createDirectories(path);

			    log.debug("Directory is created!");

			  } catch (IOException e) {

				  log.debug("Failed to create directory!" + e.getMessage());

			  }
	}

}
