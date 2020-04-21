package com.example.datatest.aop;

import java.lang.annotation.*;

/**
 * @Author xuebiao
 * @Date 2020/4/21 10:36
 * @Description:
 **/
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
public @interface EnableLogStore {

}
