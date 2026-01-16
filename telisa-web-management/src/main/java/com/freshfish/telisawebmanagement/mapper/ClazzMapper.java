package com.freshfish.telisawebmanagement.mapper;

import com.freshfish.telisawebmanagement.entity.Clazz;
import com.freshfish.telisawebmanagement.entity.ClazzQueryParam;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ClazzMapper {
    public Long getTotal();


    List<Clazz> getList(ClazzQueryParam clazzQueryParam);

    void deleteById(Integer id);

    void insert(Clazz clazz);

    Clazz getById(Integer id);

    void updateById(Clazz clazz);

    List<Clazz> list();
}
