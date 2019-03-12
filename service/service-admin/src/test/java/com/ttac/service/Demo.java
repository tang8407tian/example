package com.ttac.service;

import com.ttac.service.base.service.IdService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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
        long nextId = idService.getNextId();
        log.info("生成id:{}", nextId);
    }




}
