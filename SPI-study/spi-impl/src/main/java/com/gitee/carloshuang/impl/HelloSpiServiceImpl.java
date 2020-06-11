package com.gitee.carloshuang.impl;

import com.gitee.carloshuang.api.HelloSpiService;

/**
 * api接口实现类.
 *
 * @author: Carlos Huang
 * @Date: 6-11
 */
public class HelloSpiServiceImpl implements HelloSpiService {
    @Override
    public void sayHello(String name) {
        System.out.println("hello " + name);
    }
}
