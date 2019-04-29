package com.github.dragonhht.rmi.client;

import com.github.dragonhht.rmi.client.stub.ProxyHandler;

/**
 * .
 *
 * @author: huang
 * @Date: 2019-4-29
 */
public class Client {

    /**
     * 获取服务类接口.
     * @param url 服务端服务类绑定的url
     * @param clazz 服务类类型
     * @param <T>
     * @return 服务类
     */
    public static <T> T lookup(String url, Class<T> clazz) {
        return (T) ProxyHandler.newInstance(url, clazz);
    }

}
