package com.ttac.service.mybatis.controller.user;


import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.ttac.service.mybatis.dao.entity.User;
import com.ttac.service.mybatis.service.UserService;
import com.ttac.service.mybatis.vo.JsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author init
 * @description 用户表 前端控制器
 * @since 2019-07-23
 */
@RestController
@RequestMapping("/user")
@Api(tags = "用户表")
@Slf4j
public class UserController {
    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private UserService userService;



    @ApiOperation(value = "添加用户", notes = "添加用户")
    @GetMapping("/addUser")
    public JsonResult addUser(){


        User user = new User();
        user.setAccountNumber("root");
        user.setPassword("root");
        user.setTelephone("18227763203");
        user.setBalance(new BigDecimal("1000"));
        user.setVersion(0);
        userService.save(user);
        return JsonResult.success(user.getId());
    }

    @GetMapping("/getUserBalance")
    @ApiOperation("获取用户存款信息")
    public JsonResult getUserBalance(String id){
//        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor();
        ExecutorService service = Executors.newCachedThreadPool();
        CountDownLatch start = new CountDownLatch(1);
        CountDownLatch latch = new CountDownLatch(10);

        for (int i = 0; i < 10; i++) {
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    log.info("线程：{}开始执行",Thread.currentThread().getName());
                    try {
                        start.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }finally {
                        latch.countDown();
                    }
                    User po = userService.getById(id);
                    log.info("获取用户信息:{}", po);
                    Integer version = po.getVersion();
                    po.setBalance(po.getBalance().subtract(new BigDecimal("50")));
                    po.setVersion(version + 1);
                    log.info("更新的数据查询信息id:{}、version:{}",po.getId(), version);
                    boolean flag = userService.update(po, Wrappers.query(new User()).eq("id", po.getId()).eq("version", version));
                    if (flag) {
                        log.info("当前线程:{}、更新成功:{}", Thread.currentThread().getName(), po);
                    }else {
                        log.error("当前线程:{}、更新失败:{}", Thread.currentThread().getName(),po);
                    }
                }
            };
            service.execute(runnable);
        }
        log.info("线程：{} CountDownLatch start 开始执行", Thread.currentThread().getName());
        start.countDown();
        try {
            log.info("线程：{}CountDownLatch latch 开始阻塞", Thread.currentThread().getName());
            latch.await();
            log.info("线程：{}   11111", Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        service.shutdown();
        return JsonResult.success();
    }



    @GetMapping("/getUserBalance2")
    @ApiOperation("获取用户存款信息")
    public JsonResult getUserBalance2(String id){
//        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor();
        ExecutorService service = Executors.newCachedThreadPool();
        CountDownLatch start = new CountDownLatch(1);
        CountDownLatch latch = new CountDownLatch(10);

        for (int i = 0; i < 10; i++) {
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    log.info("线程：{}开始执行",Thread.currentThread().getName());
                    try {
                        start.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }finally {
                        latch.countDown();
                    }
                    User po = userService.getById(id);
                    log.info("获取用户信息:{}", po);
                    Integer version = po.getVersion();
                    po.setBalance(po.getBalance().subtract(new BigDecimal("50")));
                    po.setVersion(po.getVersion() + 1);
                    Boolean flag = userService.updateBalance(po);
                    log.info("当前线程:{}、更新成功:{}", Thread.currentThread().getName(), po);

                }
            };
            service.execute(runnable);
        }
        log.info("线程：{} CountDownLatch start 开始执行", Thread.currentThread().getName());
        start.countDown();
        try {
            log.info("线程：{}CountDownLatch latch 开始阻塞", Thread.currentThread().getName());
            latch.await();
            log.info("线程：{}   11111", Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        service.shutdown();
        return JsonResult.success();
    }


}
