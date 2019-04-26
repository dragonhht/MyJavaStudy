package com.github.dragonhht.ws;

/**
 * .
 *
 * @author: huang
 * @Date: 2019-3-17
 */
@javax.jws.WebService
public class WebServiceImpl implements WebService {
    @Override
    public String sayHello(String name) {
        System.out.println("server say hello " + name);
        return "hello " + name;
    }
}
