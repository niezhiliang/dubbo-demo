package com.niezhiliang.dubbo.common.service;

import java.util.Date;
import java.util.List;

/**
 * @author niezhiliang
 * @date 2022/3/15 10:09
 */
public interface HelloService {

    /**
     * 限流测试方法
     * 
     * @return
     */
    String limit() throws Throwable;

    /**
     * 熔断响应时间测试方法
     * 
     * @return
     */
    String rt() throws Throwable;

    /**
     * 熔断异常数测试方法
     * 
     * @return
     */
    String exceptionCount() throws Throwable;

    String generic(String name, Integer age, Date birthday);

    String testTypeConvert(List<Short> nums);
}
