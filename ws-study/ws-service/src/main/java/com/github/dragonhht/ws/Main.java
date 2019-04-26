package com.github.dragonhht.ws;

import javax.xml.ws.Endpoint;

/**
 * .
 *
 * @author: huang
 * @Date: 2019-3-17
 */
public class Main {

    public static void main(String[] args) {
        String addrass = "http://localhost:8081/web/sayHello";
        Endpoint.publish(addrass, new WebServiceImpl());
        System.out.println("发布成功....");
    }

}
