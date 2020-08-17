package com.ttac.service.mybatis.service.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class JdkProxy implements InvocationHandler {

    /**
     * proxy:代理类代理的真实代理对象com.sun.proxy.$Proxy0
     * method:我们所要调用某个对象真实的方法的Method对象
     * args:指代代理对象方法传递的参数
     * 参数说明：
     * Object proxy：指最终生成的代理实例，一般不会用到。
     * Method method：要调用的方法
     * Object[] args：方法调用时所需要的参数
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//        method.invoke()
        return null;
    }
}
