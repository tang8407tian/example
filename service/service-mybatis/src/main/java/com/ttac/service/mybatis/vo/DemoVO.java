package com.ttac.service.mybatis.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * description:
 *
 * @author bang.tang
 * @date 2020/8/10--10:03
 */
@Data
public class DemoVO {

    @ApiModelProperty("姓名")
    private String name;

    @ApiModelProperty("年龄")
    private Integer age;

    @ApiModelProperty("id")
    private String id;
}
