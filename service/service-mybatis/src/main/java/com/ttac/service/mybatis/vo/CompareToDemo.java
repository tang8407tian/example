package com.ttac.service.mybatis.vo;

import lombok.Data;

import java.math.BigDecimal;

/**
 * description:
 *
 * @author bang.tang
 * @date 2020/1/6--14:23
 */
@Data
public class CompareToDemo {

    public static CompareToDemo getVO = getInstance();

    private String name;

    private BigDecimal price;

    private double age;

//    private CompareToDemo() {
//    }

    private static CompareToDemo getInstance(){
        return new CompareToDemo();
    }
}
