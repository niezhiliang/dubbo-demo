package spring.test.config;

import javax.annotation.PostConstruct;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @author niezhiliang
 * @version v
 * @date 2022/8/11 13:26
 */
// @Component
public class Common implements ApplicationContextAware, InitializingBean {
    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext act) throws BeansException {
        this.applicationContext = act;
    }

    @PostConstruct
    public void init() {
        System.out.println("PostConstruct -----");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet -----");
    }
}
