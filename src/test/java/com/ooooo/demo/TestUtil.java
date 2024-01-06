package com.ooooo.demo;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

/**
 * @author <a href="https://github.com/ooooo-youwillsee">ooooo</a>
 * @since 1.0.0
 */
public class TestUtil {

    public static final int count = 5000;

    public static Long userId = 1L;

    public static void sleep(int milliseconds) {
        try {
            TimeUnit.MILLISECONDS.sleep(milliseconds);
        } catch (InterruptedException ignored) {
        }
    }

    public static void randomSleep() {
        int time = ThreadLocalRandom.current().nextInt(10, 2000);
        try {
            TimeUnit.NANOSECONDS.sleep(time);
        } catch (InterruptedException ignored) {
        }
    }
}
