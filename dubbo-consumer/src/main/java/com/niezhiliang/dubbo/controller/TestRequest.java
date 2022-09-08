package com.niezhiliang.dubbo.controller;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * 测试Request
 * 
 * @author niezhiliang
 * @version v
 * @date 2022/9/8 14:59
 */
@Data
public class TestRequest implements Serializable {
    /**
     * id
     */
    private Long id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 生日
     */
    private Date time;
}
