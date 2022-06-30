package com.navneet.learning.bms.bookmyshownamingserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class BookMyShowNamingServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookMyShowNamingServerApplication.class, args);
	}

}
