package com.dailyaccumulation.pattern.Proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class ProxyTest {

    public static void main(String[] args){
        //被代理的真实对象
        ICoder coder = new JavaCoder("Zhang ");
        //创建中介类实例
        InvocationHandler handler = new DynamicCoderProxy(coder);
        //获取类加载器
        ClassLoader classLoader = coder.getClass().getClassLoader();
        //动态产生一个代理类
        ICoder proxy = (ICoder) Proxy.newProxyInstance(classLoader, coder.getClass().getInterfaces(), handler);

        proxy.implDemands("Modify user management ");
    }
}
