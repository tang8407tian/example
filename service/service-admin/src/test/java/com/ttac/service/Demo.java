package com.ttac.service;

import com.ttac.service.base.service.IdService;
import com.ttac.service.util.BPwdEncoderUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;

/**
 * introduce：
 *
 * @date: 2018/10/22
 * @author: bang.tang
 * @time: 14:52
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class Demo {

    @Autowired
    private IdService idService;

    @Test
    public void demo1() {

        String root = BPwdEncoderUtil.encode("root");
        log.info(root);


//        long nextId = idService.getNextId();
//        log.info("生成id:{}", nextId);
    }

    @Test
    public void dddssTest(){
        LocalDate now = LocalDate.now();
        log.info("当前时间:{}", now);
        LocalDate localDate = now.minusDays(1L);
        log.info("减去后时间:{}", localDate);
        log.error("1122331321");
        throw new NullPointerException("除数为0");
    }


    @Test
    public void numberTest(){
        log.info("20/2:{}", 20/2);
        log.info("20%2:{}", 20%2);
        log.info("20/20:{}", 20/20);
        log.info("20%20:{}", 20%20);
        log.info("20/200:{}", 20/200);
        log.info("20%200:{}", 20%200);
    }




}
