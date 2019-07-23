package com.ttac.service.myabtis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author fish
 */
@MapperScan("com.ttac.service.myabtis.dao.mapper")
@SpringBootApplication
public class ServiceMybatisApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceMybatisApplication.class, args);
    }

}
