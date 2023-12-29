package com.application.webapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class WebapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebapiApplication.class, args);
	}

}
