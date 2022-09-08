package spring.test.config.transaction;

import java.io.FileNotFoundException;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author niezhiliang
 * @version v
 * @date 2022/8/12 9:37
 */
public class Test {
    public static void main(String[] args) throws FileNotFoundException {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(DBConfig.class);
        UserMapper mapper = applicationContext.getBean(UserMapper.class);
        mapper.noTransaction();
        // mapper.updateUserAndScore(1, 99);
    }
}
