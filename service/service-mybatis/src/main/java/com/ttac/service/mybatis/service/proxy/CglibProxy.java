package com.ttac.service.mybatis.service.proxy;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibProxy implements MethodInterceptor {

    /**
     *  Object为由CGLib动态生成的代理类实例，
     *  Method为上文中实体类所调用的被代理的方法引用，Object[]为参数值列表，MethodProxy为生成的代理类对方法的代理引用。
     * @param o 为由CGLib动态生成的代理类实例，
     * @param method 为上文中实体类所调用的被代理的方法引用
     * @param objects Object[]为参数值列表
     * @param methodProxy MethodProxy为生成的代理类对方法的代理引用
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
//        method.invoke();
        return null;
    }
}
