package com.niezhiliang.dubbo.factory;

/**
 * @author niezhiliang
 * @date 2022/3/17 16:02
 */
public abstract class Factory {
   public abstract <T> T getObject(Class<T> clazz);
}
