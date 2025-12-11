package com.green_india;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class GreenIndiaApplication {
	public static void main(String[] args) {
		SpringApplication.run(GreenIndiaApplication.class, args);
	}
}

