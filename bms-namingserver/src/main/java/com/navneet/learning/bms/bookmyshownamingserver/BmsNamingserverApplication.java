package com.navneet.learning.bms.bookmyshownamingserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class BmsNamingserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(BmsNamingserverApplication.class, args);
	}

}
