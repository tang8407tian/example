package com.ttac.service.mybatis.controller;


import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class ThreadTest {


    @Test
    public void threadPoolTest(){
        new Thread()
        ScheduledExecutorService threadPool = Executors.newScheduledThreadPool(1);
        threadPool.schedule(new Runnable() {
            @Override
            public void run() {
                log.info("");
            }
        },1, TimeUnit.MINUTES);
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(10);
        fixedThreadPool.submit(new Callable<Object>() {
            @Override
            public Object call() throws Exception {
                log.info("submit方法能执行callable方法、runnable方法!");
                return null;
            }
        });
        fixedThreadPool.submit(new Runnable() {
            @Override
            public void run() {
                log.info("submit方法能执行runnable方法、callable方法!");

            }
        });
        fixedThreadPool.execute(new Runnable() {
            @Override
            public void run() {
                log.info("execute方法只能执行runnable方法!");
            }
        });
    }
}

class ThreadSafe extends Thread {
    public void run() {
        while (!isInterrupted()){ //非阻塞过程中通过判断中断标志来退出
            try{
                Thread.sleep(5*1000);//阻塞过程捕获中断异常来退出
            }catch(InterruptedException e){
                e.printStackTrace();
                break;//捕获到异常之后，执行 break 跳出循环
            }
        }
    }
}
