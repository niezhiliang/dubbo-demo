// package spring.test.config;
//
// import java.lang.reflect.Method;
// import java.util.Objects;
//
// import org.aopalliance.intercept.MethodInterceptor;
// import org.apache.dubbo.common.utils.CollectionUtils;
// import org.springframework.aop.TargetSource;
// import org.springframework.aop.framework.autoproxy.AbstractAutoProxyCreator;
// import org.springframework.aop.support.AopUtils;
// import org.springframework.beans.BeansException;
// import org.springframework.stereotype.Component;
//
// import spring.test.config.annotations.CustomizedAnnotation;
//
/// **
// * @author niezhiliang
// * @version v
// * @date 2022/8/16 14:10
// */
// @Component
// public class CustomizedScanner extends AbstractAutoProxyCreator {
//
// private MethodInterceptor interceptor;
//
// @Override
// protected Object wrapIfNecessary(Object bean, String beanName, Object cacheKey) {
//
// try {
// // Class<?> serviceInterface = SpringProxyUtils.findTargetClass(bean);
// // Class<?>[] interfacesIfJdk = SpringProxyUtils.findInterfaces(bean);
//
// if (!existsAnnotation(new Class[] {bean.getClass()})) {
// return bean;
// }
// if (Objects.isNull(interceptor)) {
// interceptor = new MyMethodIntercep();
// }
// if (!AopUtils.isAopProxy(bean)) {
// bean = super.wrapIfNecessary(bean, beanName, cacheKey);
// } else {
// // AdvisedSupport advised = SpringProxyUtils.getAdvisedSupport(bean);
// // Advisor[] advisor = buildAdvisors(beanName, getAdvicesAndAdvisorsForBean(null, null, null));
// // int pos = 0;
// // for (Advisor avr : advisor) {
// // // Find the position based on the advisor's order, and add to advisors by pos
// // advised.addAdvisor(pos++, avr);
// // }
// }
// // PROXYED_SET.add(beanName);
// return bean;
// } catch (Exception e) {
// throw new RuntimeException(e);
// }
//
// }
//
// @Override
// protected Object[] getAdvicesAndAdvisorsForBean(Class<?> beanClass, String beanName,
// TargetSource customTargetSource) throws BeansException {
// return new Object[] {interceptor};
// }
//
// private boolean existsAnnotation(Class<?>[] classes) {
// if (CollectionUtils.isNotEmpty(classes)) {
// for (Class<?> clazz : classes) {
// if (clazz == null) {
// continue;
// }
// CustomizedAnnotation trxAnno = clazz.getAnnotation(CustomizedAnnotation.class);
// if (trxAnno != null) {
// return true;
// }
// Method[] methods = clazz.getMethods();
// for (Method method : methods) {
// trxAnno = method.getAnnotation(CustomizedAnnotation.class);
// if (trxAnno != null) {
// return true;
// }
// }
// }
// }
// return false;
// }
// }
