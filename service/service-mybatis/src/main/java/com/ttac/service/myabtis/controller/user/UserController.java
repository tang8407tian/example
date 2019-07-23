package com.ttac.service.myabtis.controller.user;


import com.ttac.service.myabtis.service.UserService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    private UserService userService;


}
