package com.github.dragonhht.rmi;

import com.github.dragonhht.rmi.service.HelloService;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 * �ͻ��˵���Զ�̷���.
 *
 * @author: huang
 * @Date: 2019-4-27
 */
public class Client {

    public static void main(String[] args) {
        try {
            // ��ȡ�������
            HelloService service = (HelloService) Naming.lookup("rmi://localhost:9999/hello");
            // ���÷���ӿ�
            System.out.println(service.hello("dragonhht"));

        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

}
