package com.github.dragonhht.ws;

/**
 * .
 *
 * @author: huang
 * @Date: 2019-3-17
 */
public class Client {
    public static void main(String[] args) {
        WebServiceImplService webServiceImplService = new WebServiceImplService();
        WebServiceImpl service = webServiceImplService.getWebServiceImplPort();
        System.out.println(service.sayHello("dragonhht"));
    }
}
