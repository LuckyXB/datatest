package com.example.datatest.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author xuebiao
 * @Date 2020/3/18 15:32
 * Description:
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Test implements Serializable {

    private  Integer  id;

    private String name;

}
