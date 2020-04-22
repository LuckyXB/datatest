package com.example.datatest.filter;

import javax.servlet.Filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyFilters {

	@Bean
	public FilterRegistrationBean<Filter> addFilter() {
		FilterRegistrationBean<Filter> bean = new FilterRegistrationBean<>();
		bean.setFilter(new GlobalFilter());
		bean.addUrlPatterns("/*");// 注意这个匹配方式
		return bean;
	}
}
