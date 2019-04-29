package com.github.dragonhht.rmi.server.process;

import com.github.dragonhht.rmi.server.model.CallObject;
import com.github.dragonhht.rmi.utils.ReflectionUtil;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;

/**
 * .
 *
 * @author: huang
 * @Date: 2019-4-29
 */
public class Process implements Runnable {
    private Map<String, Object> serviceMap;
    private int port;

    public Process(Map<String, Object> serviceMap, int port) {
        this.serviceMap = serviceMap;
        this.port = port;
    }

    @Override
    public void run() {
        try {
            ServerSocket server = new ServerSocket(port);
            while (true) {
                Socket socket = server.accept();
                try (InputStream socketIs = socket.getInputStream();
                     OutputStream socketOs = socket.getOutputStream();
                     ObjectInputStream ois = new ObjectInputStream(socketIs);
                     ByteArrayOutputStream bos = new ByteArrayOutputStream();
                     ObjectOutputStream oos = new ObjectOutputStream(bos);){
                    CallObject callObject = (CallObject)ois.readObject();
                    Object target = serviceMap.get(callObject.getUrl());
                    // 方法调用
                    if (callObject.isCallMethod()) {
                        target = ReflectionUtil.INSTANCE.invokeMethod(target, callObject.getMethod(), callObject.getParams());
                    }
                    oos.writeObject(target);
                    socketOs.write(bos.toByteArray());
                    socketOs.flush();
                } catch (IOException | ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
