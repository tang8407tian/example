package com.ttac.test.api.thread;

import lombok.extern.slf4j.Slf4j;
import sun.rmi.runtime.Log;

/**
 * introduce：线程方式一  继承thread
 *
 * @date: 2018/12/24
 * @author: bang.tang
 * @time: 10:43
 */
@Slf4j
public class MyThread extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            log.info("线程池中:{}正在执行！当前i:{}", Thread.currentThread().getName(), i);
        }
    }

    public MyThread() {
    }

    public MyThread(String name) {
        super(name);
    }
}

@Slf4j
class ExtendThreadDemo {
    public static void main(String[] args) {
        MyThread thread1 = new MyThread();
        MyThread thread2 = new MyThread();
        thread1.start();
        thread2.start();
        MyThread thread = new MyThread("自定义线程1");
        thread.start();
        MyThread thread3 = new MyThread();
        thread3.setName("自定义线程名称方式二");
        thread3.start();
        log.info("当前线程:{}", Thread.currentThread().getName());
    }
}
