package com.ttac.servicesimpledemo;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class Demo {


    @Test
    public void tets() {
        ExecutorService executorService = Executors.newCachedThreadPool();

        log.info("测试开始");
        Runnable runnable = () -> log.info("线程:{}启动", Thread.currentThread().getName());
        runnable.run();
        Thread thread = new Thread(runnable);
        thread.start();
    }

    @Test
    public void test1(){
        Demo3 demo3 = new Demo3();
        Thread thread = new Thread(demo3);
        thread.start();
        demo3.run();

        try {
            Thread.sleep(1000);
            log.info("sleep");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            log.info("finally");
        }
    }




    class ext implements Runnable{

        @Override
        public void run() {

        }
    }

    class demo1 implements Runnable{

        @Override
        public void run() {

        }
    }

    class demo2 extends Thread{

        @Override
        public void run() {
            super.run();
        }
    }

    class Demo3 extends Thread implements Runnable{
        @Override
        public void run() {
            log.info("{}执行了", Thread.currentThread().getName());
        }
    }
}
