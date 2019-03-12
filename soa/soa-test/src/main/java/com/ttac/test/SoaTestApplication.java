package com.ttac.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author fish
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.ttac.service.base","com.ttac.test"})
public class SoaTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SoaTestApplication.class, args);
	}
}
