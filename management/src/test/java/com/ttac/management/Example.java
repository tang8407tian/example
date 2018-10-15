package com.ttac.management;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * introduce：测试
 *
 * @date: 2018/10/12
 * @author: bang.tang
 * @time: 15:03
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class Example {


    @Test
    public void threadTest(){
        ThreadLocal<Object> objectThreadLocal = new ThreadLocal<>();
    }
}
