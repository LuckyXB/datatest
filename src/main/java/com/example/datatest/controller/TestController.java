package com.example.datatest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.datatest.aop.EnableLogStore;
import com.example.datatest.dao.mapper.UserMapper;
import com.example.datatest.model.Test;
import com.example.datatest.model.User;
import com.example.datatest.resolver.CurrentUser;
import com.example.datatest.service.TestService;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author xuebiao
 * @Date 2020/3/18 15:54
 * Description:
 **/
@Slf4j
@RestController
public class TestController {

    @Autowired
    TestService testService;

    @Autowired
    UserMapper userMapper;
    
    @GetMapping("/hhh")
    @EnableLogStore
    public String getdata(){
        List<Test> results = testService.findAll();
        StringBuffer res = new StringBuffer();
        results.stream().forEach(test -> res.append(test.getId()+":"+test.getName()+" "));
        return  res.toString();
    }
    @RequestMapping("/ddd")
    @EnableLogStore
    public void creatd(@CurrentUser User user){
    	
    	log.info("id:{}",user.getId());
    	log.info("name:{}",user.getName());
    	log.info("age:{}",user.getAge());
    	log.info("email:{}",user.getEmail());
        //userMapper.insert(user);
    }
    
    @RequestMapping("/check")
    public String  heathcheck() {
    	return "gogogogo";
    }
}
