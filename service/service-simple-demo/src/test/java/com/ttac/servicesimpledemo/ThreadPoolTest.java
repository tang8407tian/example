package com.ttac.servicesimpledemo;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import com.ttac.servicesimpledemo.controller.ThreadController;
import com.ttac.servicesimpledemo.entity.vo.ThreadLocalVO;
import com.ttac.servicesimpledemo.util.DateFormatUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.concurrent.BasicThreadFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.concurrent.CustomizableThreadFactory;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.*;


/**
 * 线程池不允许使用Executors去创建，而是通过ThreadPoolExecutor的方式，
 * 这样的处理方式让写的同学更加明确线程池的运行规则，规避资源耗尽的风险。
 * 说明：Executors各个方法的弊端
 * 1）newFixedThreadPool和newSingleThreadExecutor:
 *   主要问题是堆积的请求处理队列可能会耗费非常大的内存，甚至OOM。
 * 2）newCachedThreadPool和newScheduledThreadPool:
 *   主要问题是线程数最大数是Integer.MAX_VALUE，可能会创建数量非常多的线程，甚至OOM。
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class ThreadPoolTest {

    @Autowired
    private ThreadController threadController;
//    static ThreadLocal<ThreadLocalVO> threadLocal = new ThreadLocal<>();
//
//    public ThreadPoolTest(){
//        ThreadLocalVO vo = new ThreadLocalVO();
//        vo.setNumber(5);
//        threadLocal.set(vo);
//
//    }

    @Test
    public void threadLocalTest() {
        ThreadLocal<ThreadLocalVO> threadLocal = new ThreadLocal<>();
        ThreadLocalVO vo = new ThreadLocalVO();
        vo.setNumber(5);
        threadLocal.set(vo);
        ThreadLocalVO threadLocalVO = threadLocal.get();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                if (null != threadLocalVO) {
                    log.info("thread:[{}]--value：{}", Thread.currentThread().getName(), threadLocalVO.getNumber());
                    threadLocalVO.setNumber(9);
                    log.info("thread:[{}]--修改value：{}", Thread.currentThread().getName(), threadLocalVO.getNumber());
                } else {
                    log.error("thread：【{}】数据为空!", Thread.currentThread().getName());
                }
            }
        });
        t1.setName("测试线程1");
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                if (null != threadLocalVO) {
                    log.info("thread:[{}]--value：{}", Thread.currentThread().getName(), threadLocalVO.getNumber());
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    threadLocalVO.setNumber(23);
                    log.info("thread:[{}]--修改value：{}", Thread.currentThread().getName(), threadLocalVO.getNumber());
                } else {
                    log.error("thread：【{}】数据为空!", Thread.currentThread().getName());
                }
            }
        });
        t2.setName("测试线程2");
        t1.start();
        t2.start();

    }

    /**
     * 时间差:11014 ms
     * 2020-07-29 17:09:28.341 - [spring 线程工厂-1] INFO  com.ttac.servicesimpledemo.ThreadPoolTest 行号:182 - 线程组：线程工厂111，线程:spring 线程工厂-1， result=20
     * 2020-07-29 17:10:23.774  INFO 83648 --- [  spring 线程工厂-4] c.ttac.servicesimpledemo.ThreadPoolTest  : 线程组：线程工厂111，线程:spring 线程工厂-4， result=20
     */
    @Test
    public  void test2() {
        Timestamp start = new Timestamp(System.currentTimeMillis());
        Integer x = 0;
        ExecutorService executorService = Executors.newFixedThreadPool(10, new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                Thread thread = new Thread(r);
                thread.setName("测试线程池线程");
                return thread;
            }
        });

        Thread.currentThread();
        // ThreadPoolTaskExecutor是对ThreadPoolExecutor进行了封装处理。
        // 有一个 private ThreadPoolExecutor threadPoolExecutor;
        // 任务队列使用 LinkedBlockingQueue SynchronousQueue
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        List<Object> objects = Collections.synchronizedList(new ArrayList<>());
        taskExecutor.setQueueCapacity(10);

        // Spring 框架提供的 CustomizableThreadFactory。
        CustomizableThreadFactory customizableThreadFactory = new CustomizableThreadFactory();
        customizableThreadFactory.setThreadNamePrefix("spring 线程工厂-");
        customizableThreadFactory.setThreadGroupName("线程工厂111");
        // Apache commons-lang3 提供的 BasicThreadFactory.
        BasicThreadFactory.Builder builder = new BasicThreadFactory.Builder();
        BasicThreadFactory build = builder.namingPattern("Apache 线程-").build();
        // Google guava 工具类 提供的 ThreadFactoryBuilder ,使用链式方法创建。
        ThreadFactory guavaThreadFactory = new ThreadFactoryBuilder().setNameFormat("Google guava-线程-").build();
        new DelayQueue<>();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5,
                5,
                60,
                TimeUnit.MINUTES,
                new LinkedBlockingQueue<>(),
                customizableThreadFactory,
                new ThreadPoolExecutor.CallerRunsPolicy());
        for (int i = 0; i <= 24; i++) {
            int finalI1 = i;
//            executorService.execute(()-> threadController.addTask(x, finalI1));
            // execute方式
            threadPoolExecutor.execute(() -> addTask(x, finalI1));
            // submit 方式   通过submit.get();获取异常信息
//            Future<?> submit = threadPoolExecutor.submit(() -> addTask(x, finalI1));
//            try {
//                Object o = submit.get();
//                log.info("submit 返回值：{}", o);
//            } catch (InterruptedException e) {
//                log.error(" InterruptedException 错误：{}--{}",e, e.getMessage());
//
////                e.printStackTrace();
//            } catch (ExecutionException e) {
//                log.error(" ExecutionException 错误：{}--{}",e, e.getMessage());
//
////                e.printStackTrace();
//            }
        }

        executorService.shutdown();
        executorService.shutdownNow();
        while (!executorService.isTerminated()) {

        }
        Timestamp end = new Timestamp(System.currentTimeMillis());
        log.info("开始时间:{}", DateFormatUtils.dataTime(start));
        log.info("结束时间:{}", DateFormatUtils.dataTime(end));
        log.info("时间差:{} ms", end.getTime() - start.getTime());
    }

    /**
     * 时间差:101102 ms
     */
    @Test
    public void test3() {
        Timestamp start = new Timestamp(System.currentTimeMillis());
        Integer x = 0;
        for (int i = 0; i <= 100; i++) {
            threadController.addTask(x, i);
            addTask(x, i);
        }
        Timestamp end = new Timestamp(System.currentTimeMillis());
        log.info("开始时间:{}", DateFormatUtils.dataTime(start));
        log.info("结束时间:{}", DateFormatUtils.dataTime(end));
        log.info("时间差:{} ms", end.getTime() - start.getTime());
    }

    private void addTask(int a, int b) {
        Thread thread = Thread.currentThread();
        log.warn("warn测试");

        if (b == 10) {
            log.error("线程组：{}，线程:{}， result={}", thread.getThreadGroup().getName(), thread.getName(), b);
//            try {
            int s = a / 1;
//            } catch (Exception e) {
//                log.error("错误：{}--{}，线程组：{}，线程:{}， result={}",e, e.getMessage(),thread.getThreadGroup().getName(), thread.getName(),b);
////                e.printStackTrace();
//            }
        }
        double result = a + b;
        log.info("线程组：{}，线程:{}， result={}", thread.getThreadGroup().getName(), thread.getName(), b);
    }


    public void switchTest(){

        List<Object> objects = Collections.synchronizedList(new ArrayList<>());
        Byte by = null;
        Short st = null;
        Integer s = null;
        Character c = null;
        String si = null;


        Long l = null;
        Float f = null;
        Double d = null;
        switch (si){

        }
    }

    @Test
    public void epx3Test(){
        Integer s = 1==1 ? 1:2;
        log.info("s={}", s);

        MathOperation  d = (a, b) -> a + b;
    }
    public Integer add(){
        return 1;
    }

    interface MathOperation {
        int operation(int a, int b);
    }



}
