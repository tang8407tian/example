package com.ttac.service.mybatis.controller.lock;

import com.ttac.service.mybatis.aop.LockTest;
import com.ttac.service.mybatis.service.UserService;
import com.ttac.service.mybatis.vo.DemoVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.Executors;

/**
 * description:  数据库锁示例
 *
 * @author bang.tang
 * @date 2019/7/25--9:59
 */

@Api(tags = "数据库锁示例")
@RestController
@RequestMapping("/soa/data/base/lock/controller")
@Slf4j
public class DataBaseLockController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "注解锁测试", notes = "注解锁测试")
    @GetMapping("/lockTest")
    @LockTest(prefix = "uuid",key = "ceshi")
    public void lockTest(@RequestParam String id, @RequestParam String name, @RequestParam Integer age){
        log.info("DataBaseLockController参数:id:{},name:{},age:{}",id,name,age);
    }


    @ApiOperation(value = "注解锁测试2-vo", notes = "注解锁测试2")
    @PostMapping("/lockTest2")
    @LockTest(prefix = "uuid",key = "vo")
    public void lockTest2(@RequestBody DemoVO vo){\
        Executors.newSingleThreadExecutor()
        log.info("DataBaseLockController参数vo:{}",vo);
    }
}
