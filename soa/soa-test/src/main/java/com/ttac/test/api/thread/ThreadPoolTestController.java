package com.ttac.test.api.thread;

import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * introduce：
 *
 * @date: 2018/12/24
 * @author: bang.tang
 * @time: 10:47
 */
@RestController
public class ThreadPoolTestController {

    public void createThreadPool(){
        ExecutorService pool = Executors.newFixedThreadPool(2);
        MyThread myThread = new MyThread();
        MyThread myThread1 = new MyThread();
        MyThread myThread2 = new MyThread();
        MyThread myThread3 = new MyThread();
        MyThread myThread4 = new MyThread();
        MyThread myThread5 = new MyThread();

        pool.execute(myThread);
        pool.execute(myThread1);
        pool.execute(myThread2);
        pool.execute(myThread3);
        pool.execute(myThread4);
        pool.execute(myThread5);

    }
}
