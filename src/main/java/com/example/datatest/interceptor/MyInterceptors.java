package com.example.datatest.interceptor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyInterceptors implements WebMvcConfigurer {
	
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(getTestDataInterceptor()// new TestDataInterceptor() 
				).addPathPatterns("/**");
	}

	@Bean
	public TestDataInterceptor getTestDataInterceptor() {
		return new TestDataInterceptor();
	}
}
