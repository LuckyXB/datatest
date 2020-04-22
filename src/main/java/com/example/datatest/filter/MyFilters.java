package com.example.datatest.filter;

import javax.servlet.Filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;

@Configuration
public class MyFilters {

	@Bean
	public FilterRegistrationBean<Filter> addFilter() {
		FilterRegistrationBean<Filter> bean = new FilterRegistrationBean<>();
		bean.setFilter(new GlobalFilter());
		bean.setOrder(Ordered.LOWEST_PRECEDENCE);
		bean.addUrlPatterns("/hhh");
		return bean;
	}
}
