package com.navneet.learning.bms.bmsclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class BmsClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(BmsClientApplication.class, args);
	}

}
