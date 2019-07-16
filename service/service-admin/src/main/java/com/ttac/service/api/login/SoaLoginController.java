package com.ttac.service.api.login;

import com.ttac.entity.admin.vo.request.login.LoginRequestVO;
import com.ttac.service.util.JsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * description:
 *
 * @author bang.tang
 * @date 2019/7/16--14:36
 */
@Api(tags = "登录")
@RestController
@RequestMapping("/soa/login/controller")
public class SoaLoginController {

    @ApiOperation("登录")
    @PostMapping("/login")
    public JsonResult login(@RequestBody LoginRequestVO loginRequestVO){
        return JsonResult.success();
    }

}
