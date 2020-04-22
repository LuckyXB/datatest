package com.example.datatest.interceptor;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

import com.example.datatest.jwt.JWTUtil;

import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TestDataInterceptor implements HandlerInterceptor {

	public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object handler)
			throws Exception {
		
		String reqUrl = httpServletRequest.getRequestURI();
		if(StrUtil.equals(reqUrl, "/login")) {
			return false;
		}
		String token = httpServletRequest.getHeader("Authorization");
		if (StrUtil.isEmpty(token)) {
			token = httpServletRequest.getParameter("accessToken");
		}
		if (StrUtil.isEmpty(token)) {
			log.error("token is null");
			responseError(httpServletResponse,"token is null");
			return false;
		}
		Claims claims = JWTUtil.parseJWT(token);
		if(claims == null) {
			log.error("token parse error");
			responseError(httpServletResponse,"token parse error");
			return false;
		}
		Date expiration = claims.getExpiration();
		if(expiration.before(new Date())) {
			log.error("token expired");;
			responseError(httpServletResponse,"token expired");
			return false;
		}
		return true;
	}
	
	private void responseError(HttpServletResponse resp,String message) throws IOException {
		resp.setContentType("text/plain;charset=UTF-8");
		Map<String, String> resultMap = new HashMap<>(10);
		resultMap.put("code", "500");
		resultMap.put("error", message);
		resp.getWriter().write(JSONUtil.toJsonStr(resultMap));
	}
}
