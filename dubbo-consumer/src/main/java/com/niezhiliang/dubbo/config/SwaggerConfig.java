package com.niezhiliang.dubbo.config;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import cn.willingxyz.restdoc.core.config.RestDocConfig;
import cn.willingxyz.restdoc.springswagger3.EnableSwagger3;

/**
 * @author niezhiliang
 * @version v
 * @date 2022/9/8 14:20
 */
@Configuration
@EnableSwagger3
public class SwaggerConfig {
    @Bean
    RestDocConfig _swaggerConfig() {
        return RestDocConfig.builder().apiTitle("标题").apiDescription("描述呀").apiVersion("1.0.0")
            .packages(Arrays.asList("com.niezhiliang.dubbo")).build();
    }
}