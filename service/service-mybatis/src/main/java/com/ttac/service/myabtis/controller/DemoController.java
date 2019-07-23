package com.ttac.service.myabtis.controller;


import com.ttac.service.myabtis.service.DemoService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author init
 * @description  前端控制器
 * @since 2019-07-23
 */
@RestController
@RequestMapping("/demo")
@Api(tags = "")
@Slf4j
public class DemoController {
    @Autowired
    private DemoService demoService;


}
