package com.github.dragonhht.rmi;

import com.github.dragonhht.rmi.service.HelloService;
import com.github.dragonhht.rmi.service.impl.HelloServiceImpl;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

/**
 * 服务端发布.
 *
 * @author: huang
 * @Date: 2019-4-27
 */
public class Service {

    public static void main(String[] args) {
        try {
            // 实例化服务对象
            HelloService service = new HelloServiceImpl();
            // 注册远程调用对象
            LocateRegistry.createRegistry(9999);
            Naming.bind("rmi://localhost:9999/hello", service);

            System.out.println("发布成功...");
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (AlreadyBoundException e) {
            e.printStackTrace();
        }
    }
}
