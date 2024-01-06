package com.ooooo.demo;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static com.ooooo.demo.TestUtil.userId;

/**
 * 更新策略：先更新缓存（更新或者删除）, 后更新数据库
 *
 * @author <a href="https://github.com/ooooo-youwillsee">ooooo</a>
 * @since 1.0.0
 */
class CacheConsistencyApplicationTest3 {

    private static final Logger LOGGER = LoggerFactory.getLogger(CacheConsistencyApplicationTest3.class);

    private UserCache userCache = new UserCache();

    private UserDB userDB = new UserDB();

    private ExecutorService executor = Executors.newFixedThreadPool(8);

    @Test
    void test() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(2);
        userDB.setUserNameById(userId, "0");

        // 一个线程，更新
        executor.submit(() -> {
            set1(userId, "1");
            countDownLatch.countDown();
        });

        // 一个线程，更新
        executor.submit(() -> {
            set2(userId, "2");
            countDownLatch.countDown();
        });
        countDownLatch.await();

        // 检查缓存和数据库的数据是否一致
        String cacheUserName = userCache.queryUserNameById(userId);
        String dbUserName = userDB.queryUserNameById(userId);
        LOGGER.info("cacheUserName: {}, dbUserName: {}", cacheUserName, dbUserName);
    }


    public void set1(Long id, String username) {
        // 更新缓存
        TestUtil.sleep(100);
        userCache.setUserNameById(id, username);
        // 更新数据库
        userDB.setUserNameById(id, username);
    }

    public void set2(Long id, String username) {
        // 更新缓存
        userCache.setUserNameById(id, username);
        // 更新数据库
        TestUtil.sleep(200);
        userDB.setUserNameById(id, username);
    }

}