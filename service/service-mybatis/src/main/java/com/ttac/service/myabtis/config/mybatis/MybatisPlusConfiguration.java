package com.ttac.service.myabtis.config.mybatis;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author changlei
 * @date 2019/5/14 18:18
 */
@Configuration
public class MybatisPlusConfiguration {

    /**
     * mybatis-plus分页插件<br>
     * 文档：http://mp.baomidou.com<br>
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
//        开启 PageHelper 的支持
//        paginationInterceptor.setLocalPage(true);
        paginationInterceptor.setDialectType("mysql");

        return paginationInterceptor;
    }
}
