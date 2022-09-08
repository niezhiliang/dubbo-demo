package spring.test.config;

import org.springframework.stereotype.Component;

import spring.test.config.annotations.CustomizedAnnotation;

/**
 * @author niezhiliang
 * @version v
 * @date 2022/8/11 13:24
 */
@Component
public class B {
    // @Value("${dubbo.application.name}")
    // private String name;
    //
    // @Autowired
    // private Common common;

    @CustomizedAnnotation
    public void testAop() {
        System.out.println("--------testAop");
    }

}
