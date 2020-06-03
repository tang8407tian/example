package com.ttac.service.mybatis.controller.lock;

import com.ttac.service.mybatis.service.UserService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
