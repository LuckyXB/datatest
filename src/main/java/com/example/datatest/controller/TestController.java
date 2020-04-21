package com.example.datatest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.datatest.aop.EnableLogStore;
import com.example.datatest.model.Test;
import com.example.datatest.service.TestService;

/**
 * @Author xuebiao
 * @Date 2020/3/18 15:54
 * Description:
 **/
@RestController
public class TestController {

    @Autowired
    TestService testService;

    @GetMapping("/hhh")
    @EnableLogStore
    public String getdata(){
        List<Test> results = testService.findAll();
        StringBuffer res = new StringBuffer();
        results.stream().forEach(test -> res.append(test.getId()+":"+test.getName()+" "));
        return  res.toString();
    }
    @RequestMapping("/ddd")
    public void creatd(){
        Test t = new Test();
        t.setId(3);
        t.setName("xuebiao");
        testService.insertd(t);
    }
}
