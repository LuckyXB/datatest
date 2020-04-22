package com.example.datatest.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.datatest.dao.mapper.UserMapper;
import com.example.datatest.jwt.JWTUtil;
import com.example.datatest.model.User;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.json.JSONUtil;

@RestController
public class LoginController {

	@Autowired
	private UserMapper userMapper;
	
	@PostMapping("/login")
	public ResponseEntity<String> login(HttpServletRequest req,HttpServletResponse resp) throws IOException {
		
		QueryWrapper<User> wrapper = new QueryWrapper<>();
		wrapper.eq("name", req.getParameter("username"));
		List<User> users = userMapper.selectList(wrapper);
		
		if(CollUtil.isNotEmpty(users)) {
			User currnetUser = users.get(0);
			req.getSession().setAttribute("currentUser", currnetUser);
			String token = JWTUtil.createJWT(currnetUser.getId(), currnetUser.getName());
			
			return new ResponseEntity<>(token,HttpStatus.OK);
		}else {
			resp.setContentType("text/plain;charset=UTF-8");
			Map<String, String> resultMap = new HashMap<>(10);
			resultMap.put("code", "404");
			resultMap.put("error", "用户不存在！");
			resp.getWriter().write(JSONUtil.toJsonStr(resultMap));
		}
		return null;
	}
}
