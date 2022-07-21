package com.niezhiliang.dubbo;

import com.niezhiliang.dubbo.strategy.calculate.Calculate;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author niezhiliang
 * @date 2022/3/23 15:02
 */
public class MyInvocationHandler implements InvocationHandler {


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("我是动态代理的方法呀。。。。");
        return "success";
    }

    public static void main(String[] args) {
        Calculate o = (Calculate) Proxy.newProxyInstance(MyInvocationHandler.class.getClassLoader(), new Class[]{
                Calculate.class}, new MyInvocationHandler());
        System.out.println(o.strategyImple());

    }

}
