package com.ttac.servicesimpledemo.design;


import com.ttac.servicesimpledemo.entity.vo.JsonResult;

/**
 * 观察者模式
 */
public interface SendMessage {

    JsonResult sendMessage(String message);
}
