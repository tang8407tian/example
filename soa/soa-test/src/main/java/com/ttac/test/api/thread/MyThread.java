package com.ttac.test.api.thread;

import lombok.extern.slf4j.Slf4j;

/**
 * introduce：
 *
 * @date: 2018/12/24
 * @author: bang.tang
 * @time: 10:43
 */
@Slf4j
public class MyThread extends Thread{

    @Override
    public void run() {
        log.info("线程池中:{}正在执行！",Thread.currentThread().getName());
    }
}
