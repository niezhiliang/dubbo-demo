package spring.test.config;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import spring.test.config.annotations.CustomizedAnnotation;

/**
 * @author niezhiliang
 * @version v
 * @date 2022/8/16 14:07
 */
public class MyMethodIntercep implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        // invocation.getMethod().getAnnotation(CustomizedAnnotation.class)
        if (invocation.getMethod().isAnnotationPresent(CustomizedAnnotation.class)) {

            System.out.println("MyMethodIntercep before");
            Object proceed = invocation.proceed();
            System.out.println("MyMethodIntercep after");
            return proceed;
        }
        return invocation.proceed();
    }

}
