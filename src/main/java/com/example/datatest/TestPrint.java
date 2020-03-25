package com.example.datatest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;

/**
 * 
 * @Author xuebiao
 * @Date 2020年3月25日
 * @Description:
 */
@Slf4j
@Component
public class TestPrint implements CommandLineRunner {

    @Autowired
    DataSource dataSource;

    @Override
    public void run(String... args) throws Exception {

        Connection connection = dataSource.getConnection();
        log.info(connection.toString());
        connection.close();

    }
}
