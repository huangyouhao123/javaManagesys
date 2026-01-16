package com.freshfish.telisawebmanagement.mapper;

import com.freshfish.telisawebmanagement.entity.Log;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface LogMapper {
    @Select("select * from operation_log limit #{start},#{pageSize}")
    List<Log> page(Integer start, Integer pageSize);
}
