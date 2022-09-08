package spring.test.config.aop;

import org.springframework.stereotype.Component;

/**
 * @author niezhiliang
 * @version v
 * @date 2022/8/11 17:31
 */
@Component
public class AopTest {

    public int add(int a, int b) {
        int c = a + b;
        return c;
    }

}
