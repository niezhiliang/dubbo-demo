package com.niezhiliang.dubbo.factory;

/**
 * @author niezhiliang
 * @date 2022/3/17 16:07
 */
public class FactoryCommon extends Factory {

    @Override
    public <T> T getObject(Class<T> clazz) {
        T t = null;
        try {
             t = clazz.newInstance();
            return t;
        } catch (Exception e) {

        }
        return t;
    }
}
