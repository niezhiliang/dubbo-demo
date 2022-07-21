
/*
 * Decompiled with CFR.
 *
 * Could not load the following classes: com.niezhiliang.dubbo.common.service.HelloService
 */
package org.apache.dubbo.common.bytecode;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.apache.dubbo.rpc.service.Destroyable;
import org.apache.dubbo.rpc.service.GenericException;
import org.apache.dubbo.rpc.service.GenericService;

import com.alibaba.dubbo.rpc.service.EchoService;
import com.niezhiliang.dubbo.common.service.HelloService;

public class proxy2 implements ClassGenerator.DC, GenericService, Destroyable, EchoService, HelloService {
    public static Method[] methods;
    private InvocationHandler handler;

    @Override
    public CompletableFuture $invokeAsync(String string, String[] stringArray, Object[] objectArray)
        throws GenericException {
        Object[] objectArray2 = new Object[] {string, stringArray, objectArray};
        Object object = null;
        try {
            object = this.handler.invoke(this, methods[0], objectArray2);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return (CompletableFuture)object;
    }

    @Override
    public Object $invoke(String string, String[] stringArray, Object[] objectArray) throws GenericException {
        Object[] objectArray2 = new Object[] {string, stringArray, objectArray};
        Object object = null;
        try {
            object = this.handler.invoke(this, methods[1], objectArray2);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return object;
    }

    @Override
    public void $destroy() {
        Object[] objectArray = new Object[] {};
        try {
            Object object = this.handler.invoke(this, methods[2], objectArray);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

    @Override
    public Object $echo(Object object) {
        Object[] objectArray = new Object[] {object};
        Object object2 = null;
        try {
            object2 = this.handler.invoke(this, methods[3], objectArray);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return object2;
    }

    @Override
    public String limit() throws Throwable {
        Object[] objectArray = new Object[] {};
        Object object = this.handler.invoke(this, methods[4], objectArray);
        return (String)object;
    }

    public String exceptionCount() throws Throwable {
        Object[] objectArray = new Object[] {};
        Object object = this.handler.invoke(this, methods[5], objectArray);
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

    public String rt() throws Throwable {
        Object[] objectArray = new Object[] {};
        Object object = this.handler.invoke(this, methods[6], objectArray);
        return (String)object;
    }

    public proxy2() {}

    public proxy2(InvocationHandler invocationHandler) {
        this.handler = invocationHandler;
    }
}
