package com.niezhiliang.dubbo.provider.mapper;

import spring.test.config.transaction.User;

/**
 * @author niezhiliang
 * @version v
 * @date 2022/8/17 9:55
 */
public interface UserMapper {
    User selectByPrimary(Integer id);
}
