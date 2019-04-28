package com.github.dragonhht.rmi.server;

/**
 * .
 *
 * @author: huang
 * @Date: 2019-4-28
 */
public class HelloServiceImpl implements HelloService {
    @Override
    public String hello(String name) {
        return "hello simple " + name;
    }
}
