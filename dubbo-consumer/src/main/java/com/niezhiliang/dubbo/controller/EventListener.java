package com.niezhiliang.dubbo.controller;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.ServletRequestHandledEvent;

import com.alibaba.fastjson.JSON;

/**
 * @author niezhiliang
 * @version v
 * @date 2022/7/26 17:22
 */
@Component
public class EventListener implements ApplicationListener<ServletRequestHandledEvent> {
    @Override
    public void onApplicationEvent(ServletRequestHandledEvent event) {
        System.out.println(JSON.toJSONString(event));
    }
}
