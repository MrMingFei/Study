package com.dailyaccumulation.theory.Proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class DynamicCoderProxy implements InvocationHandler {

    private ICoder coder;

    public DynamicCoderProxy(ICoder coder){
        this.coder = coder;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(System.currentTimeMillis());
        Object result = method.invoke(coder, args);
        System.out.println(System.currentTimeMillis());
        return result;
    }
}
