package com.ooooo.demo;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/**
 * 模拟用户缓存
 *
 * @author <a href="https://github.com/ooooo-youwillsee">ooooo</a>
 * @since 1.0.0
 */
public class UserCache implements UserOperation {

    private final Map<Long, String> cache = new HashMap<>();

    @Override
    public synchronized String queryUserNameById(Long id) {
        return cache.get(id);
    }

    @Override
    public synchronized void setUserNameById(Long id, String userName) {
        cache.put(id, userName);
    }
}
