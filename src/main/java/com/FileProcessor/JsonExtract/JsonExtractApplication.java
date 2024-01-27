package com.FileProcessor.JsonExtract;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JsonExtractApplication {

	public static void main(String[] args) {
		SpringApplication.run(JsonExtractApplication.class, args);
		JsonExtract jsonExtract = new JsonExtract();
		jsonExtract.convertJson();
	}

}
