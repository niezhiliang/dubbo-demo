package com.niezhiliang.dubbo.controller;

import java.util.Date;
import java.util.List;

import com.niezhiliang.dubbo.common.service.HelloService;

/**
 * @author niezhiliang
 * @date 2022/4/15 11:19
 */
public class Test2 implements HelloService {

    /**
     * 异常熔断降级代码
     * 
     * @param e
     * @return
     */
    public static String fallBackHandler(Throwable e) {
        return "开始熔断降级: " + e.getMessage();
    }

    @Override
    public String limit() throws Throwable {
        return "mock data";
    }

    @Override
    public String rt() throws Throwable {
        return null;
    }

    @Override
    public String exceptionCount() throws Throwable {
        return null;
    }

    @Override
    public String generic(String name, Integer age, Date birthday) {
        return null;
    }

    @Override
    public String testTypeConvert(List<Short> nums) {
        return null;
    }
}
