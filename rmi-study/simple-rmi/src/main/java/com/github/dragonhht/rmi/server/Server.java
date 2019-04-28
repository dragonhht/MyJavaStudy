package com.github.dragonhht.rmi.server;

import com.github.dragonhht.rmi.server.model.CallObject;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * .
 *
 * @author: huang
 * @Date: 2019-4-28
 */
public class Server {

    private Map<String, Object> serviceMap = new ConcurrentHashMap<>();

    public static void registry(int port) {

    };

    public void start(int port, String url, Object service) {
        serviceMap.put(url, service);
        new Thread(() -> {
            try {
                ServerSocket server = new ServerSocket(port);
                while (true) {
                    Socket socket = server.accept();
                    try (InputStream socketIs = socket.getInputStream();
                         ObjectInputStream ois = new ObjectInputStream(socketIs);
                         ByteArrayOutputStream bos = new ByteArrayOutputStream();
                         ObjectOutputStream oos = new ObjectOutputStream(bos);){
                        CallObject callObject = (CallObject)ois.readObject();
                        Object target = this.serviceMap.get(callObject.getUrl());

                        oos.writeObject(service);
                    } catch (IOException | ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }

}
