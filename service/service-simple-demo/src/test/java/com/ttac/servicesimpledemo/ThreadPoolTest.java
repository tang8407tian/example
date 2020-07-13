package com.ttac.servicesimpledemo;

import com.ttac.servicesimpledemo.entity.vo.ThreadLocalVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class ThreadPoolTest {
//    static ThreadLocal<ThreadLocalVO> threadLocal = new ThreadLocal<>();
//
//    public ThreadPoolTest(){
//        ThreadLocalVO vo = new ThreadLocalVO();
//        vo.setNumber(5);
//        threadLocal.set(vo);
//
//    }

    @Test
    public void threadLocalTest(){
        ThreadLocal<ThreadLocalVO> threadLocal = new ThreadLocal<>();
        ThreadLocalVO vo = new ThreadLocalVO();
        vo.setNumber(5);
        threadLocal.set(vo);
        ThreadLocalVO threadLocalVO = threadLocal.get();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                if (null != threadLocalVO){
                    log.info("thread:[{}]--value：{}", Thread.currentThread().getName(), threadLocalVO.getNumber());
                    threadLocalVO.setNumber(9);
                    log.info("thread:[{}]--修改value：{}", Thread.currentThread().getName(), threadLocalVO.getNumber());
                }else {
                    log.error("thread：【{}】数据为空!", Thread.currentThread().getName());
                }
            }
        });
        t1.setName("测试线程1");
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                if (null != threadLocalVO){
                    log.info("thread:[{}]--value：{}", Thread.currentThread().getName(), threadLocalVO.getNumber());
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    threadLocalVO.setNumber(23);
                    log.info("thread:[{}]--修改value：{}", Thread.currentThread().getName(), threadLocalVO.getNumber());
                }else {
                    log.error("thread：【{}】数据为空!", Thread.currentThread().getName());
                }
            }
        });
        t2.setName("测试线程2");
        t1.start();
        t2.start();

    }
}
