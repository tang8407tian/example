package com.ttac.entity.admin.vo.demo;

import lombok.Data;

/**
 * introduce：
 *
 * @date: 2018/11/21
 * @author: bang.tang
 * @time: 14:47
 */
@Data
public class Demo1 {

    private Integer age;

    private Long bigAge;

    private String name;


    public Demo1() {
    }

    public Demo1(Integer age, String name) {
        this.age = age;
        this.name = name;
    }

    public Demo1(Integer age, Long bigAge, String name) {
        this.age = age;
        this.bigAge = bigAge;
        this.name = name;
    }
}
