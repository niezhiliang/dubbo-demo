package com.niezhiliang.dubbo.controller;

import java.util.Arrays;
import java.util.Date;

import org.apache.dubbo.config.ReferenceConfig;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.rpc.service.GenericService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.niezhiliang.dubbo.common.service.HelloService;

import lombok.extern.slf4j.Slf4j;

/**
 * @author niezhiliang
 * @date 2022/3/15 10:23
 */
@RestController
@Slf4j
public class IndexController {
    @DubboReference(mock = "fail:return null")
    private HelloService helloService;

    @GetMapping(value = "generic")
    public Object genericService() {
        // 引用远程服务
        // 该实例很重量，里面封装了所有与注册中心及服务提供方连接，请缓存
        ReferenceConfig<GenericService> reference = new ReferenceConfig<>();
        // 弱类型接口名
        reference.setInterface(HelloService.class.getName());
        reference.setVersion("1.0");
        // 声明为泛化接口
        reference.setGeneric("true");

        // 用org.apache.dubbo.rpc.service.GenericService可以替代所有接口引用
        GenericService genericService = reference.get();

        // 基本类型以及Date,List,Map等不需要转换，直接调用
        Object result =
            genericService.$invoke("generic", new String[] {"java.lang.String", "java.lang.Integer", "java.util.Date"},
                new Object[] {"zhangsan", "18", new Date()});
        return result;
    }

    /**
     * 基于qps限流
     * 
     * @return
     */
    @GetMapping(value = "qps")
    // @SentinelResource(value = "qps", blockHandler = "blockHandler")
    public String qpslimit() throws Throwable {
        return helloService.limit();
    }

    /**
     * 测试dubbo List泛型类型转换
     *
     * @return
     */
    @GetMapping(value = "test")
    public String test() throws Throwable {
        log.info("test------");
        return helloService.testTypeConvert(Arrays.asList((short)1, (short)2));
    }

    /**
     * 熔断降级-响应时间
     * 
     * @return
     */
    @GetMapping(value = "rt")
    @SentinelResource(value = "rt", fallback = "fallBackHandler")
    public String rt() throws Throwable {
        return helloService.rt();
    }

    /**
     * 熔断降级-异常数
     * 
     * @return
     */
    @GetMapping(value = "exceptionCount")
    @SentinelResource(value = "exceptionCount", fallback = "fallBackHandler", fallbackClass = Test2.class)
    public String exceptionCount() throws Throwable {
        return helloService.exceptionCount();
    }

    /**
     * 异常熔断降级代码
     * 
     * @param e
     * @return
     */
    public String fallBackHandler(Throwable e) {
        return "开始熔断降级: " + e.getMessage();
    }

    /**
     * qps限流方法
     * 
     * @param e
     * @return
     */
    public String blockHandler(BlockException e) {
        return "资源限流" + e.getMessage();
    }

}
