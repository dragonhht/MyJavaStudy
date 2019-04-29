package com.github.dragonhht.rmi.server;

import com.github.dragonhht.rmi.server.process.Process;

import java.util.Map;
import java.util.concurrent.*;

/**
 * .
 *
 * @author: huang
 * @Date: 2019-4-28
 */
public class Server {

    private static final int threadSize = 100;
    private static Map<String, Object> serviceMap = new ConcurrentHashMap<>();
    private static ExecutorService executorService = new ThreadPoolExecutor(threadSize, threadSize, 0L,
            TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>());

    public static void start(int port, String url, Object service) {
        serviceMap.put(url, service);
        executorService.execute(new Process(serviceMap, 9999));
    }

}
