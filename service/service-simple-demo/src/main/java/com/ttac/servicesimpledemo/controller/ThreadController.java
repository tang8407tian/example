package com.ttac.servicesimpledemo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;

import java.sql.SQLException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

@Controller
@Slf4j
public class ThreadController {

    public   void addTask(int a, int b) {
        double result = a + b;
        try {
            Thread.sleep(1000);
            new SQLException();
            new Error();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("线程：{}， result={}",Thread.currentThread().getName(),result);
    }

    public void taskPool(){
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        ExecutorService executorService1 = Executors.newCachedThreadPool();
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(10);
        ExecutorService executorService2 = Executors.newSingleThreadExecutor();
    }
}
