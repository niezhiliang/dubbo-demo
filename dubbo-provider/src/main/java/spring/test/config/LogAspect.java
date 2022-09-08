package spring.test.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * @author niezhiliang
 * @version v
 * @date 2022/8/11 17:29
 */
// @Component
// @Aspect
// @EnableAspectJAutoProxy
public class LogAspect {
    @Pointcut("within(spring.test.config.aop.*)")
    public void pointCut() {}

    @Around("pointCut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {

        System.out.println("around before-----------");
        Object result = joinPoint.proceed();
        System.out.println("around after-----------");
        return result;

    }

    @Before("pointCut()")
    public void before(JoinPoint joinPoint) {

        System.out.println("before-----------");

    }

    @After("pointCut()")
    public void after(JoinPoint joinPoint) {

        System.out.println("after -----------");

    }

    @AfterReturning(pointcut = "pointCut()", returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result) {

        System.out.println("afterReturning -----------");

        result = 998;

    }

    @AfterThrowing(value = "pointCut()", throwing = "e")
    public void afterReturning(JoinPoint joinPoint, Throwable e) {

        System.out.println("afterReturning -----------");

    }

}
