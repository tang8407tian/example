package com.ttac.service.mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author fish
 */
@MapperScan("com.ttac.service.mybatis.dao.mapper")
//@ComponentScan("com.ttac.service.base")
@SpringBootApplication
public class ServiceMybatisApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceMybatisApplication.class, args);
    }

}
