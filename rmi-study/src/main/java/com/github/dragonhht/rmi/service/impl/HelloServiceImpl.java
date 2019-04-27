package com.github.dragonhht.rmi.service.impl;

import com.github.dragonhht.rmi.service.HelloService;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * .
 *
 * @author: huang
 * @Date: 2019-4-27
 */
public class HelloServiceImpl extends UnicastRemoteObject implements HelloService {

    public HelloServiceImpl() throws RemoteException {

    }

    public String hello(String name) throws RemoteException {
        System.out.println("接口被调用...");
        return "hello " + name;
    }
}
