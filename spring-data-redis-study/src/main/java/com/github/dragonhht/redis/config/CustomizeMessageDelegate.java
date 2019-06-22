package com.github.dragonhht.redis.config;

import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Map;

/**
 * .
 *
 * @author: huang
 * @Date: 2019-6-14
 */
@Component("listener")
public class CustomizeMessageDelegate implements MessageDelegate {
    @Override
    public void handleMessage(String message) {
        System.out.println("处理消息: " + message);
    }

    @Override
    public void handleMessage(Map message) {
        System.out.println("处理消息: " + message);
    }

    @Override
    public void handleMessage(byte[] message) {
        System.out.println("处理消息: " + message);
    }

    @Override
    public void handleMessage(Serializable message) {
        System.out.println("处理消息: " + message);
    }

    @Override
    public void handleMessage(Serializable message, String channel) {
        System.out.println("处理消息: " + message);
    }
}
