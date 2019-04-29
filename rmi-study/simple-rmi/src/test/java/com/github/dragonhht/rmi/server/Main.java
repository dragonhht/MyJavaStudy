package com.github.dragonhht.rmi.server;

/**
 * .
 *
 * @author: huang
 * @Date: 2019-4-28
 */
public class Main {

    public static void main(String[] args) {
        HelloService helloService = new HelloServiceImpl();
        Server.start(9999, "rmi://localhost:9999/hello", helloService);
    }

}
