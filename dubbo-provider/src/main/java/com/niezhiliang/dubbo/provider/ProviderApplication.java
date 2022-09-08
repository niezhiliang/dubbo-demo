package com.niezhiliang.dubbo.provider;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.niezhiliang.dubbo.provider.mapper.UserMapper;

/**
 * @author niezhiliang
 * @date 2022/3/15 9:59
 */
@SpringBootApplication(scanBasePackages = "com.niezhiliang.dubbo.provider")
@MapperScan(basePackages = "com.niezhiliang.dubbo.provider.mapper")
public class ProviderApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(ProviderApplication.class, args);
        UserMapper userMapper = applicationContext.getBean(UserMapper.class);
    }
}
