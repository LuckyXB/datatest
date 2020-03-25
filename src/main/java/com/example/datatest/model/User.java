package com.example.datatest.model;

import lombok.Data;

/**
 * @Author xuebiao
 * @Date 2020/3/24 17:32
 * @Description:
 **/
@Data
public class User {
    private Long id;
    private String name;
    private Integer age;
    private String email;
}
