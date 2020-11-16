package com.ttac.servicesimpledemo;

import com.ttac.servicesimpledemo.util.IdSnowflakeWorker;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Random;
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

    @Test
    public void test3(){
        Integer num = 5;
        Integer numf = 100;
        Integer s = num << 1;
        Integer f = numf >> 1;
        Integer s1 = num << 2;
        Integer f1 = numf >> 2;
        Integer s2 = num << 3;
        Integer f2 = numf >> 3;
        Integer s3 = num << 4;
        Integer f3 = numf >> 4;
        log.info("s:{}",s);
        log.info("s:{}",s1);
        log.info("s:{}",s2);
        log.info("s:{}",s3);
        log.info("f:{}",f);
        log.info("f:{}",f1);
        log.info("f:{}",f2);
        log.info("f:{}",f3);

        Object[] t = {};
        Object[] t1 = null;
        log.info("t:{}", t.length);
        log.info("t1:{}", t1.length);
        StringBuilder builder = new StringBuilder();
        builder.append("");
        HashMap<Object, Object> objectObjectHashMap = new HashMap<>(1);
        objectObjectHashMap.entrySet().iterator();
        HashMap<Object, Object> map = new HashMap<>(44);

    }

    @Test
    public void exceptionTest(){


        int a = 0;
        int b = 0;
        int c = 0;
        for(int i=0; i<9;i++){
            log.info("before a={},b={}", a, b);
            a = a++;
            b = ++b;
//            c = a++;
            log.info("after a={},b={}", a, b);

        }
        log.info("a={},b={},c={}", a, b,c);
//        try {
//            Integer s = 4/0;
//            HashMap<Object, Object> map = new HashMap<>();
//            map.size();
//        } catch (Exception e) {
//            String localizedMessage = e.getLocalizedMessage();
//            Throwable fill = e.fillInStackTrace();
//            log.error("错误信息 fill :{}",fill);
//            log.error("错误信息local:{}",localizedMessage);
//            log.error("错误信息:{}",e);
//        }

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



    @Test
    public void testId(){
        for (int i=0; i<= 100 ; i++){
            Long generateId = IdSnowflakeWorker.getGenerateId();
            log.info("ID=:{}", generateId);
        }
    }

    @Test
    public void randomId(){
        Random random = new Random();
        StringBuilder pid = new StringBuilder();
        int hashCode = pid.toString().hashCode();
        log.info("hashCode:{}", hashCode);
        for (int i=0; i<= 100 ; i++){
            log.info("ID=:{}", random.nextInt(30));
        }
    }
}
