package spring.test.config;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author niezhiliang
 * @version v
 * @date 2022/8/11 13:29
 */
public class Test {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(Config.class);
        B bean = applicationContext.getBean(B.class);
        bean.testAop();
        // for (Method method : B.class.getMethods()) {
        // CustomizedAnnotation annotation = AnnotationUtils.findAnnotation(method, CustomizedAnnotation.class);
        // if (annotation != null) {
        // System.out.println(annotation);
        // }
        // }
    }
}
