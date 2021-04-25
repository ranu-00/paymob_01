package com.innovate.paymob;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@EntityScan(basePackages="com.paymob.common.paymob_common.bucketlistmodel")
public class PaymobBucketlistApplication {

	public static void main(String[] args) {
		SpringApplication.run(PaymobBucketlistApplication.class, args);
	}

}
