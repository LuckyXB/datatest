package com.example.datatest;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Author xuebiao
 * @Date 2020/3/18 14:12
 * Description: 数据源配置类
 **/
@Configuration
@MapperScan("com.example.datatest.dao.mapper")
public class DataSourceConfig {
}
