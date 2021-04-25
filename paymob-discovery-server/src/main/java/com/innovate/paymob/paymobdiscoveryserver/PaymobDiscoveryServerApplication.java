package com.innovate.paymob.paymobdiscoveryserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class PaymobDiscoveryServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(PaymobDiscoveryServerApplication.class, args);
	}

}
