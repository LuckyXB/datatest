package com.example.datatest.filter;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.datatest.jwt.JWTUtil;

import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import io.jsonwebtoken.Claims;
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
		HttpServletRequest httpServletRequest = (HttpServletRequest) req;
		HttpServletResponse httpServletResponse = (HttpServletResponse) res;
		String reqUrl = httpServletRequest.getRequestURI();
		
		log.info("reqUrl:"+reqUrl);
//		if(StrUtil.equals(reqUrl, "/login")) {
//			chain.doFilter(req, res);
//		}
//		String token = httpServletRequest.getHeader("Authorization");
//		if (StrUtil.isEmpty(token)) {
//			token = httpServletRequest.getParameter("accessToken");
//		}
//		if (StrUtil.isEmpty(token)) {
//			log.error("token is null");
//			responseError(httpServletResponse,"token is null");
//			return;
//		}
//		Claims claims = JWTUtil.parseJWT(token);
//		if(claims == null) {
//			log.error("token parse error");;
//			responseError(httpServletResponse,"token parse error");
//			return;
//		}
//		Date expiration = claims.getExpiration();
//		if(expiration.before(new Date())) {
//			log.error("token expired");;
//			responseError(httpServletResponse,"token expired");
//			return;
//		}
		chain.doFilter(req, res);
	}

	public void destroy() {

		log.info("----------------------->过滤器被销毁");
	}

	/**
	 * 错误页
	 * @param resp
	 * @throws IOException
	 */
	private void responseError(HttpServletResponse resp,String message) throws IOException {
		resp.setContentType("text/plain;charset=UTF-8");
		Map<String, String> resultMap = new HashMap<>(10);
		resultMap.put("code", "500");
		resultMap.put("error", message);
		resp.getWriter().write(JSONUtil.toJsonStr(resultMap));
	}
}
