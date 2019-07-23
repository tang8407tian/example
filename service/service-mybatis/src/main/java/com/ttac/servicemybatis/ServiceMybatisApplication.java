package com.ttac.servicemybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author fish
 */
@MapperScan("com.ttac.servicemybatis.dao.mapper")
@SpringBootApplication
public class ServiceMybatisApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceMybatisApplication.class, args);
    }

}
