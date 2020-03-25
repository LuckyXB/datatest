package com.example.datatest.dao.mapper;

import com.example.datatest.model.Test;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author xuebiao
 * @Date 2020/3/18 15:35
 * Description:
 **/
@Mapper
public interface TestMapper {

    @Insert("insert into TEST values (#{id},#{name})")
    void  insertModel(@Param("id") Integer id, @Param("name") String name);

    @Select("select * from TEST")
    List<Test> selectAll();
}
