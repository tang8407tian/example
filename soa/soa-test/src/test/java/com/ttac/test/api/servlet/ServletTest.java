package com.ttac.test.api.servlet;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import java.io.*;
import java.time.LocalDate;

/**
 * description:
 *
 * @author bang.tang
 * @date 2019/5/9--15:32
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class ServletTest extends HttpServlet {


    @Test
    public void ddTest() {
//        ServletContext context = ServletTest.this.getServletContext();
//        if (null != context){
//            String servletContextName = context.getServletContextName();
//            String virtualServerName = context.getVirtualServerName();
//            log.info("当前servletContextName:{}", servletContextName);
//            log.info("当前virtualServerName:{}", virtualServerName);
//        }
        ClassLoader classLoader = ServletTest.class.getClassLoader();
        if (null != classLoader) {
            InputStream resourceAsStream = classLoader.getResourceAsStream("application.yml");
            log.info("resourceAsStream:{}", resourceAsStream.toString());
        }
    }

    @Test
    public void dddssTest(){
        LocalDate now = LocalDate.now();
        log.info("当前时间:{}", now);
        LocalDate localDate = now.minusDays(1L);
        log.info("减去后时间:{}", localDate);

    }


    @Test
    public void stringTest() {
        StringBuilder builder = new StringBuilder();
        builder.append("第一行");
        builder.append("是不是第二行");
        builder.append("\r\n");
        builder.append("是不是第二行");
        builder.append("\r\n");
        builder.append("是不是第二行");
        builder.append("\r\n");
        builder.append("是不是第二行");

        builder.append(System.lineSeparator());
        builder.append("是不是第三行");
        builder.append(System.lineSeparator());
        builder.append("是不是第四行");
        builder.append(System.lineSeparator());
        builder.append("是不是第五行");

        log.error(builder.toString());
    }

}
