package org.apache.dubbo.common.bytecode;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.List;

import org.apache.dubbo.rpc.service.Destroyable;

import com.alibaba.dubbo.rpc.service.EchoService;
import com.niezhiliang.dubbo.common.service.HelloService;

/**
 * @author niezhiliang
 * @version v
 * @date 2022/6/28 13:36
 */

public class proxy0 implements ClassGenerator.DC, Destroyable, HelloService, EchoService {
    public static Method[] methods;
    private InvocationHandler handler;

    @Override
    public void $destroy() {
        Object[] objectArray = new Object[] {};
        try {
            Object object = this.handler.invoke(this, methods[0], objectArray);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

    @Override
    public String limit() {
        Object[] objectArray = new Object[] {};
        Object object = null;
        try {
            object = this.handler.invoke(this, methods[1], objectArray);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return (String)object;
    }

    @Override
    public String exceptionCount() {
        Object[] objectArray = new Object[] {};
        Object object = null;
        try {
            object = this.handler.invoke(this, methods[2], objectArray);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return (String)object;
    }

    @Override
    public String generic(String name, Integer age, Date birthday) {
        return null;
    }

    @Override
    public String testTypeConvert(List<Short> nums) {
        return null;
    }

    @Override
    public String rt() {
        Object[] objectArray = new Object[] {};
        Object object = null;
        try {
            object = this.handler.invoke(this, methods[3], objectArray);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return (String)object;
    }

    @Override
    public Object $echo(Object object) {
        Object[] objectArray = new Object[] {object};
        Object object2 = null;
        try {
            object2 = this.handler.invoke(this, methods[4], objectArray);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return object2;
    }

    public proxy0() {}

    public proxy0(InvocationHandler invocationHandler) {
        this.handler = invocationHandler;
    }
}
