package com.github.dragonhht.rmi.server;


import com.github.dragonhht.rmi.client.Client;

/**
 * .
 *
 * @author: huang
 * @Date: 2019-4-29
 */
public class ClientTest {

    public static void main(String[] args) {
        HelloService service = Client.lookup("rmi://localhost:9999/hello", HelloService.class);
        String result = service.hello("dragonhht");
        System.out.println(result);
    }

}
