package com.ttac.service.myabtis.controller.user;


import com.ttac.service.myabtis.service.UserService;
import com.ttac.service.myabtis.vo.JsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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


    @ApiOperation(value = "demo测试", notes = "demo测试")
    @GetMapping("/demo")
    public JsonResult demo(){
        return JsonResult.success();
    }


}
