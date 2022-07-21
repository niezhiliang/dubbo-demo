package com.niezhiliang.dubbo.strategy.product;

/**
 * @author niezhiliang
 * @date 2022/3/17 16:12
 */
public class ProductA implements Product{
    @Override
    public void method() {
        System.out.println("---ProductA");
    }
}
