package com.github.dragonhht.rmi.server;

/**
 * .
 *
 * @author: huang
 * @Date: 2019-4-28
 */
public interface HelloService extends Remote {

    String hello(String name);

}
