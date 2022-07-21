// package org.apache.dubbo.common.bytecode;
//
// import com.niezhiliang.dubbo.provider.rpc.HelloServiceImpl;
// import java.lang.reflect.InvocationTargetException;
// import java.util.Map;
// import java.util.Random;
// import org.apache.dubbo.common.bytecode.ClassGenerator;
// import org.apache.dubbo.common.bytecode.NoSuchMethodException;
// import org.apache.dubbo.common.bytecode.NoSuchPropertyException;
// import org.apache.dubbo.common.bytecode.Wrapper;
//
// public class Wrapper1
// extends Wrapper
// implements ClassGenerator.DC {
// public static String[] pns;
// public static Map pts;
// public static String[] mns;
// public static String[] dmns;
// public static Class[] mts0;
// public static Class[] mts1;
// public static Class[] mts2;
//
// @Override
// public String[] getPropertyNames() {
// return pns;
// }
//
// @Override
// public boolean hasProperty(String string) {
// return pts.containsKey(string);
// }
//
// public Class getPropertyType(String string) {
// return (Class)pts.get(string);
// }
//
// @Override
// public String[] getMethodNames() {
// return mns;
// }
//
// @Override
// public String[] getDeclaredMethodNames() {
// return dmns;
// }
//
// @Override
// public void setPropertyValue(Object object, String string, Object object2) {
// try {
// HelloServiceImpl helloServiceImpl = (HelloServiceImpl)object;
// }
// catch (Throwable throwable) {
// throw new IllegalArgumentException(throwable);
// }
// if (string.equals("random")) {
// helloServiceImpl.random = (Random)object2;
// return;
// }
// throw new NoSuchPropertyException(new StringBuffer().append("Not found property \"").append(string).append("\" field
// or setter method in class com.niezhiliang.dubbo.provider.rpc.HelloServiceImpl.").toString());
// }
//
// @Override
// public Object getPropertyValue(Object object, String string) {
// HelloServiceImpl helloServiceImpl;
// try {
// helloServiceImpl = (HelloServiceImpl)object;
// }
// catch (Throwable throwable) {
// throw new IllegalArgumentException(throwable);
// }
// if (string.equals("random")) {
// return helloServiceImpl.random;
// }
// throw new NoSuchPropertyException(new StringBuffer().append("Not found property \"").append(string).append("\" field
// or setter method in class com.niezhiliang.dubbo.provider.rpc.HelloServiceImpl.").toString());
// }
//
// public Object invokeMethod(Object object, String string, Class[] classArray, Object[] objectArray) throws
// InvocationTargetException {
// HelloServiceImpl helloServiceImpl;
// try {
// helloServiceImpl = (HelloServiceImpl)object;
// }
// catch (Throwable throwable) {
// throw new IllegalArgumentException(throwable);
// }
// try {
// if ("limit".equals(string) && classArray.length == 0) {
// return helloServiceImpl.limit();
// }
// if ("exceptionCount".equals(string) && classArray.length == 0) {
// return helloServiceImpl.exceptionCount();
// }
// if ("rt".equals(string) && classArray.length == 0) {
// return helloServiceImpl.rt();
// }
// }
// catch (Throwable throwable) {
// throw new InvocationTargetException(throwable);
// }
// throw new NoSuchMethodException(new StringBuffer().append("Not found method \"").append(string).append("\" in class
// com.niezhiliang.dubbo.provider.rpc.HelloServiceImpl.").toString());
// }
// }
//
