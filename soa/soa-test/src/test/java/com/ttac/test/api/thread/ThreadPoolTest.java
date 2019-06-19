package com.ttac.test.api.thread;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.Date;

/**
 * introduce：
 *
 * @date: 2018/12/24
 * @author: bang.tang
 * @time: 10:58
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class ThreadPoolTest {

    @Autowired
    private ThreadPoolTestController threadPoolTestController;

    @Test
    public void threadPoolTest() {
        threadPoolTestController.createThreadPool();
    }


    @Test
    public void dates() {
        Date date = new Date(System.currentTimeMillis());
        java.sql.Date date1 = new java.sql.Date(System.currentTimeMillis());
        LocalDate now = LocalDate.now();
        log.info("date:{}", date);
        log.info("date:{}", date1);
        log.info("date:{}", now);
    }
}
