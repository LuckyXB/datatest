package com.example.datatest;

import java.util.Optional;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @Author xuebiao
 * @Date 2020/3/19 10:57
 * @Description:
 **/
public class XuebiaoTest {

    public static <T> Predicate<T> distinctByKey(Function<? super T,Object> keyExtractor) {
        Set<Object> seen = ConcurrentHashMap.newKeySet();
        return t -> !seen.add(keyExtractor.apply(t));
    }
    
    public static String toJSONString(Object object) {
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			return objectMapper.writeValueAsString(object);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
	}
    /**
     * 简化null判断
     * @param <T>
     * @param resolver
     * @return
     */
    public static <T> Optional<T> resolve(Supplier<T> resolver) {
        try {
            T result = resolver.get();
            return Optional.ofNullable(result);
        }
        catch (NullPointerException e) {
            return Optional.empty();
        }
    }


    static  ThreadLocal<String> share = new ThreadLocal<>();
    public static  void  main(String[] args){
        new Thread(()->{
            System.out.println(Thread.currentThread().getName());
            share.set(Thread.currentThread().getName());
        }).start();
        share.get();
    }

}
