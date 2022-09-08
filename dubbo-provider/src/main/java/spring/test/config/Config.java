package spring.test.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author niezhiliang
 * @version v
 * @date 2022/8/11 13:23
 */
@Configuration
@ComponentScan(basePackages = "spring.test.config")
@EnableAspectJAutoProxy
public class Config {}
