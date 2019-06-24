package com.ttac.service.api;

import com.ttac.entity.admin.vo.demo.DemoSearchVO;
import com.ttac.service.service.test.TestService;
import com.ttac.service.util.JsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * description:
 *
 * @author bang.tang
 * @date 2019/6/11--15:34
 */
@RestController
@Api(value = "swagger Demo", tags = "测试")
@RequestMapping("/swagger/demo")
@Slf4j
public class SwaggerDemoApiController {

    @Autowired
    private TestService testService;


    @GetMapping("/getDemo")
    @ApiOperation(value = "get请求方式Demo",notes = "get测试")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "主键id", required = true, paramType = "query"),
            @ApiImplicitParam(name = "name", value = "名称", required = true, paramType = "query"),
            @ApiImplicitParam(name = "createTime", value = "创建时间", required = true, paramType = "query", dataType = "Long")
    })
    public JsonResult getDemo(@RequestParam String id, @RequestParam String name,@RequestParam Long createTime ){
        String s = new StringBuilder().append(id).append(",").append(name).append(",").append(createTime).toString();
        return JsonResult.success(s);
    }

    @ApiOperation(value ="参数@notNull测试", notes ="参数@notNull测试")
    @GetMapping("/nullParamTest")
    public JsonResult nullParamTest(@Valid DemoSearchVO searchVO){
        log.info("搜索参数:{}", searchVO.toString());
        return JsonResult.success();
    }
}
