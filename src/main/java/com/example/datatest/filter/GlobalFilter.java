package com.example.datatest.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GlobalFilter implements Filter {

	public void init(javax.servlet.FilterConfig filterConfig) throws javax.servlet.ServletException {
		log.info("过滤器。。。。创建");
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		log.info("进入filter");
		chain.doFilter(req, res);
	}
	
	public void destroy() {
		 
        log.info("----------------------->过滤器被销毁");
    }


}
