package com.ttac.service.mybatis.service;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
abstract class Demos {

    private String de;

    private static String d;

    public abstract void add();

    public  abstract  void adds();

    private void test1(){

    }

    private static void test2(){

    }

    public  void  submit(){
        log.info("123");
    };

    public  static  void  dds(){
        log.info("123123");
    }


}
