package com.niezhiliang.dubbo.provider.rpc;

import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.util.Assert;

import com.niezhiliang.dubbo.common.service.HelloService;

import lombok.extern.slf4j.Slf4j;

/**
 * @author niezhiliang
 * @date 2022/3/15 10:20
 */
@DubboService
@Slf4j
public class HelloServiceImpl implements HelloService {

    public Random random = new Random();

    @Override
    public String limit() {
        System.out.println(System.currentTimeMillis() + " 限流方法请求");
        return "限流方法";
    }

    @Override
    public String rt() {
        System.out.println(System.currentTimeMillis() + " 熔断响应时间方法请求");
        if (random.nextBoolean()) {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (Exception e) {

            }
        }
        return "熔断——响应时间方法";
    }

    @Override
    public String exceptionCount() {
        System.out.println(System.currentTimeMillis() + " 熔断异常数方法请求");
        if (random.nextBoolean()) {
            Assert.isTrue(false, "随机异常");
        }
        return "熔断异常数方法";
    }

    @Override
    public String generic(String name, Integer age, Date birthday) {
        log.info("泛化调用 参数 name " + name + " age " + age + " birthday " + birthday);
        return "泛化调用 参数 name " + name + " age " + age + " birthday " + birthday;
    }

    @Override
    public String testTypeConvert(List<Short> nums) {
        String str = "";

        for (Short num : nums) {
            str += " " + num;
        }
        log.info("泛化调用 参数 name ");
        return str;
    }
}
