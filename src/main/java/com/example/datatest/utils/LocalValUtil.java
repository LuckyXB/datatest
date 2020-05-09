package com.example.datatest.utils;

/**
 * @param <T>
 * @Author xuebiao
 * @Date 2020/4/27 10:01
 * @Description: 线程局部变量
 **/
public  class  LocalValUtil {

    static ThreadLocal localVal = new ThreadLocal();

    public static <T> void set(final T value) {
        localVal.set(value);
    }

    public static <T> T get() {
        return (T)localVal.get();
    }

    /**
     * 使用完成后，必须remove，防止内存泄漏
     */
    public static void remove() {
        localVal.remove();
    }
}
