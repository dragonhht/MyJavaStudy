package com.github.dragonhht.rmi.client.stub;

import com.github.dragonhht.rmi.client.Client;
import com.github.dragonhht.rmi.server.model.CallObject;

import java.io.*;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.Socket;

/**
 * 使用动态代理创建类及远程调用服务接口.
 *
 * @author: huang
 * @Date: 2019-4-29
 */
public class ProxyHandler implements InvocationHandler {

    private UrlParam urlParam;

    public ProxyHandler(String url) {
        this.urlParam = new UrlParam(url);
    }

    /**
     * 创建服务类.
     * @param url 服务端中服务类绑定的url
     * @param target 服务类接口
     * @return
     */
    public static Object newInstance(String url, Class target) {
        Class[] interfaces = {target};
        return Proxy.newProxyInstance(ProxyHandler.class.getClassLoader(),
                interfaces, new ProxyHandler(url));
    }

    /**
     * 调用远程服务类，并获取结果.
     * @param urlParam url信息
     * @param method 调用的方法名
     * @param params 方法参数
     * @return 方法参数
     */
    private static Object invokeMethod(UrlParam urlParam, String method, Object[] params) {
        InputStream socketInput = null;
        ObjectInputStream ois;
        Object result = null;
        try (Socket socket = new Socket(urlParam.getHost(), urlParam.getPort());
             OutputStream outputStream = socket.getOutputStream();
             ObjectOutputStream oos = new ObjectOutputStream(outputStream)){
            CallObject callObject = new CallObject();
            callObject.setMethod(method);
            callObject.setUrl(urlParam.getUrl());
            callObject.setParams(params);
            oos.writeObject(callObject);
            socketInput = socket.getInputStream();
            ois = new ObjectInputStream(socketInput);
            result = ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (socketInput != null) {
                try {
                    socketInput.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return invokeMethod(urlParam, method.getName(), args);
    }
}
