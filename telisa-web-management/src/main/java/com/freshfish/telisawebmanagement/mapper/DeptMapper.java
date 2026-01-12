package com.freshfish.telisawebmanagement.mapper;

import com.freshfish.telisawebmanagement.entity.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DeptMapper {
//    @Results ({
//            @Result(property = "id", column = "id"),
//            @Result(property = "name", column = "name"),
//            @Result(property = "createTime", column = "create_time"),
//            @Result(property = "updateTime", column = "update_time")
//    })
    @Select("select id, name, create_time, update_time from dept order by update_time desc")
    public List<Dept> findAll();
}
