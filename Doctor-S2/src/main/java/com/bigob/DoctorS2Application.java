package com.bigob;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class DoctorS2Application {

	public static void main(String[] args) {
		SpringApplication.run(DoctorS2Application.class, args);
	}
}
