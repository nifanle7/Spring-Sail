package com.uncoverman.sail;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class SailApplication {

	public static void main(String[] args) {
		SpringApplication.run(SailApplication.class, args);
	}

}
