package com.example.datatest.resolver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import com.example.datatest.dao.mapper.UserMapper;
import com.example.datatest.jwt.JWTUtil;
import com.example.datatest.model.User;

import io.jsonwebtoken.Claims;

@Component
public class CurrentUserMethodArgumentResolver implements HandlerMethodArgumentResolver {

	@Autowired
	UserMapper userMapper;

	@Override
	public boolean supportsParameter(MethodParameter parameter) {
		if (parameter.getParameterType().isAssignableFrom(User.class)
				&& parameter.hasParameterAnnotation(CurrentUser.class)) {
			return true;
		}
		return false;
	}

	@Override
	public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
			NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
		CurrentUser currentUserAnnotation = parameter.getParameterAnnotation(CurrentUser.class);

//		HttpServletRequest request = webRequest.getNativeRequest(HttpServletRequest.class);
//		Object object = request.getSession().getAttribute(currentUserAnnotation.value());
		Object object = webRequest.getAttribute(currentUserAnnotation.value(), RequestAttributes.SCOPE_SESSION);
		if (object == null) {
			// 从 accessToken获得用户信息
			String token = webRequest.getHeader("Authorization");
			if (token == null) {
				token = webRequest.getParameter("accessToken");
			}
			// TODO
			Claims claims = JWTUtil.parseJWT(token);
			if (claims == null) {
				throw new RuntimeException("获取用户信息异常");
			}
			Integer userId = (Integer) claims.get("userId");
			// TODO: 取真实用户
			User user = userMapper.selectById(userId);
			if (user == null) {
				throw new RuntimeException("获取用户信息异常");
			}
			return user;
			// return new User(111,"admin",30,"12354@tg.com");
		}
		return object;
	}

}
