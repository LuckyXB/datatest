package com.example.datatest.interceptor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.example.datatest.resolver.CurrentUserMethodArgumentResolver;

@Configuration
public class MyInterceptors implements WebMvcConfigurer {

	@Autowired
	CurrentUserMethodArgumentResolver currentUserMethodArgumentResolver;

	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(getTestDataInterceptor()// new TestDataInterceptor()
		).addPathPatterns("/**").excludePathPatterns("/login", "/login.html").excludePathPatterns("/static/**");
	}

	public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
		resolvers.add(currentUserMethodArgumentResolver);
	}

	@Bean
	public TestDataInterceptor getTestDataInterceptor() {
		return new TestDataInterceptor();
	}
}
