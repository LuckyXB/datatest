package com.example.datatest.aop;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author xuebiao
 * @Date 2020/4/21 10:30
 * @Description: 记录请求及响应
 **/
@Component
@Aspect
@Slf4j
public class LogStoreAspect {

    /**
     * 定义切点所有的controller
     */
    @Pointcut("execution(public * *..controller..*(..))")
    public void logStore() {
    }

    @Before("logStore() && @annotation(enableLogStore)")
    public void before(final JoinPoint joinPoint, final EnableLogStore enableLogStore) {
        // 记录开始时间
        LogStoreLocal.set(System.currentTimeMillis());
    }

    @AfterReturning(returning = "returnValue", pointcut = "logStore() && @annotation(enableLogStore)")
    public void doAfterReturning(final JoinPoint joinPoint, final EnableLogStore enableLogStore, final Object returnValue) {

        try {// 获取到方法
            MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
            // 获取请求参数
            final String[] argNames = methodSignature.getParameterNames();
            final Object[] values = joinPoint.getArgs();
            // 组装请求参数
            Map<String, Object> requestData = toParamMap(argNames, values);
            //构造json日志输出
            Map<String, Object> logdata = new LinkedHashMap<>();
            
            final RequestAttributes ra = RequestContextHolder.getRequestAttributes();
            final ServletRequestAttributes sra = (ServletRequestAttributes) ra;
            final HttpServletRequest request = sra.getRequest();
            logdata.put("uri",request.getRequestURI());
            logdata.put("请求方式",request.getMethod());
            logdata.put("请求参数", requestData);
            logdata.put("响应数据", returnValue);
            logdata.put("请求耗时",(System.currentTimeMillis()-LogStoreLocal.get()));
            final String className = joinPoint.getTarget().getClass().getName();
            final String methodName = methodSignature.getName();
            logdata.put("类名",className);
            logdata.put("方法名",methodName);
            log.info(JSONUtil.toJSONString(logdata));
            //
        }catch (Exception e){
            log.error(e.getMessage(),e);
        }finally {
            LogStoreLocal.remove();
        }
    }


    private Map<String, Object> toParamMap(final String[] argNames, final Object[] values) {
        final Map<String, Object> param = new HashMap<>(50);
        if (argNames == null) {
            return param;
        }
        for (int i = 0; i < argNames.length; i++) {
            try {
                param.put(argNames[i], values[i]);
            } catch ( Exception e) {
                log.error("内部异常！");
            }
        }
        return param;
    }
}