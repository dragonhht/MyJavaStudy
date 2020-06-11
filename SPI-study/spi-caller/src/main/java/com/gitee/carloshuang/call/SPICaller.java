package com.gitee.carloshuang.call;

import com.gitee.carloshuang.api.HelloSpiService;

import java.util.ServiceLoader;

/**
 * .
 *
 * @author: Carlos Huang
 * @Date: 6-11
 */
public class SPICaller {

    public static void main(String[] args) {
        ServiceLoader<HelloSpiService> loader = ServiceLoader.load(HelloSpiService.class);
        for (HelloSpiService service : loader) {
            service.sayHello("Carlos Huang");
        }
    }

}
