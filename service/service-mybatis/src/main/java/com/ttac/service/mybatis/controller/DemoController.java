package com.ttac.service.mybatis.controller;


import com.ttac.service.mybatis.service.DemoService;
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


    public void logLog(){
        log.info("test");
        Long id = 12312L;
        String param = "多个参数1";
        String param1 = "啥啥啥";
        String param2 = "多对多";
        this.logParam("com.ttac.service.mybatis.controller.DemoControllerTest.logLog", id, param,param1,param2);
    }


    public void logParam(Object o, Object... parama){
        log.info("具体位置:{}, 参数:{}", o, parama);
    }


}
