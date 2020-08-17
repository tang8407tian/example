package com.ttac.service.mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;

import javax.servlet.MultipartConfigElement;

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


    /**
     * 文件上传配置
     * @return
     */
    @Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        //单个文件最大
        factory.setMaxFileSize("20480KB");
        /// 设置总上传数据总大小
        factory.setMaxRequestSize("204800KB");

        return factory.createMultipartConfig();
    }
}
