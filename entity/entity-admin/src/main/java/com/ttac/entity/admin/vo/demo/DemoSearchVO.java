package com.ttac.entity.admin.vo.demo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * description:
 *
 * @author bang.tang
 * @date 2019/6/24--14:40
 */
@Data
public class DemoSearchVO{

    @ApiModelProperty("名称")
    @NotBlank(message = "名称不能为空")
    private String name;

    @ApiModelProperty("年龄")
    @NotNull(message = "年龄不能为空")
    private Integer age;
}
