package com.github.dragonhht.redis.config;

import java.io.Serializable;
import java.util.Map;

/**
 * .
 *
 * @author: huang
 * @Date: 2019-6-14
 */
public interface MessageDelegate {

    void handleMessage(String message);
    void handleMessage(Map message); void handleMessage(byte[] message);
    void handleMessage(Serializable message);
    void handleMessage(Serializable message, String channel);

}
