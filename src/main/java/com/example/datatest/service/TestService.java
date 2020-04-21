package com.example.datatest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.datatest.dao.mapper.TestMapper;
import com.example.datatest.model.Test;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author xuebiao
 * @Date 2020/3/18 15:48
 * Description:
 **/
@Service
@Slf4j
public class TestService {
    @Autowired
    private TestMapper testMapper;

    public void insertd(Test t){
        testMapper.insertModel(t.getId(),t.getName());
        log.info("insert success");
    }

    public List<Test> findAll(){
        return testMapper.selectAll();
    }
}
