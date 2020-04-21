package com.example.datatest.aop;

/**
 * @Author xuebiao
 * @Date 2020/4/21 10:44
 * @Description:
 **/
public class LogStoreLocal {

    private static ThreadLocal<Long> logLocal = new ThreadLocal<>();

    public static void set(final Long value) {
        LogStoreLocal.logLocal.set(value);
    }

    public static Long get() {
        return LogStoreLocal.logLocal.get();
    }

    /**
     * 使用完成后，必须remove，防止内存泄漏
     */
    public static void remove() {
        LogStoreLocal.logLocal.remove();
    }
}
