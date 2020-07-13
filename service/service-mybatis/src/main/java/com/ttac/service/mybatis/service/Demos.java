package com.ttac.service.mybatis.service;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
abstract class Demos {

    public abstract void add();

    public  abstract  void adds();

    public  void  submit(){
        log.info("123");
    };

    public  static  void  dds(){
        log.info("123123");
    }


}
