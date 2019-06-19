package com.ttac.test.api.thread;

import lombok.extern.slf4j.Slf4j;

/**
 * description:   线程创建方式二  实现 Runnable
 *
 * @author bang.tang
 * @date 2019/3/12--17:09
 */
@Slf4j
public class MyRunable implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            log.info("当前线程名称:{}, i值:{}", Thread.currentThread().getName(), i);
        }
    }
}

class MyRunnableDemo {
    public static void main(String[] args) {
        MyRunable runable = new MyRunable();
        Thread thread1 = new Thread(runable);
        Thread thread2 = new Thread(runable);

        thread1.start();
        thread2.start();


        Thread thread3 = new Thread(runable, "自定义线程名");
        thread3.start();
        Thread thread = new Thread(runable);
        thread.setName("自定义线程名称方式2");
        thread.start();
    }
}
