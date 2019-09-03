package com.company.proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibProxy implements MethodInterceptor {
    private Object target;

    public Object getCglibProxyInstance(Object target){
        this.target = target;
        Enhancer enhancer = new Enhancer();
        //设置父类,因为Cglib是针对指定的类生成一个子类，所以需要指定父类
        enhancer.setSuperclass(target.getClass());
        enhancer.setCallback(this);// 设置回调
        Object result = enhancer.create();//创建并返回代理对象
        return result;
    }
    @Override
    public Object intercept(Object o, Method method, Object[] arr, MethodProxy methodProxy) throws Throwable {
        System.out.println("Cglib proxy before...");
        Object invoke = method.invoke(target, arr);
        System.out.println("Cglib proxy after...");
        return invoke;
    }
}
