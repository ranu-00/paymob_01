package com.innovate.paymob;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient
@EnableConfigurationProperties
@EntityScan(basePackages="com.paymob.common.paymob_common.entity")
@ComponentScan({"com.innovate.paymob.*","com.paymob.common.paymob_common.responses"})
public class SendMoneyApplication {

	public static void main(String[] args) {
		SpringApplication.run(SendMoneyApplication.class, args);
	}

}
