package com.ttac.soaconfigclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class SoaConfigClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(SoaConfigClientApplication.class, args);
    }

}
