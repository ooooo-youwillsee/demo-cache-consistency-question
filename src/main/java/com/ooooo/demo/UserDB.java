package com.ooooo.demo;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author <a href="https://github.com/ooooo-youwillsee">ooooo</a>
 * @since 1.0.0
 */
public class UserDB implements UserOperation{

    private final Map<Long, String> db = new HashMap<>();

    public synchronized String queryUserNameById(Long id) {
        return db.get(id);
    }

    @Override
    public synchronized void setUserNameById(Long id, String userName) {
        db.put(id, userName);
    }

}
