package com.github.dragonhht.rmi.service;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * .
 *
 * @author: huang
 * @Date: 2019-4-27
 */
public interface HelloService extends Remote {

    String hello(String name) throws RemoteException;

}
