package com.github.dragonhht.rmi;

import com.github.dragonhht.rmi.service.HelloService;
import com.github.dragonhht.rmi.service.impl.HelloServiceImpl;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

/**
 * ����˷���.
 *
 * @author: huang
 * @Date: 2019-4-27
 */
public class Service {

    public static void main(String[] args) {
        try {
            // ʵ�����������
            HelloService service = new HelloServiceImpl();
            // ע��Զ�̵��ö���
            LocateRegistry.createRegistry(9999);
            Naming.bind("rmi://localhost:9999/hello", service);

            System.out.println("�����ɹ�...");
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (AlreadyBoundException e) {
            e.printStackTrace();
        }
    }
}
