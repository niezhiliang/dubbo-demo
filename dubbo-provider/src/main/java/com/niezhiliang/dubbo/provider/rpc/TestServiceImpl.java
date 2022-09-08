package com.niezhiliang.dubbo.provider.rpc;

import org.apache.dubbo.config.annotation.DubboService;

import com.niezhiliang.dubbo.common.service.TestService;

/**
 * @author niezhiliang
 * @version v
 * @date 2022/8/29 16:00
 */
@DubboService
public class TestServiceImpl implements TestService {
    @Override
    public String hello(String name) {
        return null;
    }
}
