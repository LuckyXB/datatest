package com.example.datatest;

import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.datatest.dao.mapper.UserMapper;
import com.example.datatest.model.User;

@SpringBootTest
class DatatestApplicationTests {

    @Autowired
    UserMapper userMapper;
    @Test
    void contextLoads() {
    }
    @Test
    void gttt(){
        System.out.println(("----- selectAll method test ------"));
        List<User> userList = userMapper.selectList(null);
        Assert.assertTrue(userList.size()>0);
        userList.forEach(System.out::println);


    }
}
