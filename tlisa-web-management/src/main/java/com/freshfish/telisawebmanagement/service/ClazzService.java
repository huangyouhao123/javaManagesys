package com.freshfish.telisawebmanagement.service;

import com.freshfish.telisawebmanagement.entity.Clazz;
import com.freshfish.telisawebmanagement.entity.ClazzQueryParam;
import com.freshfish.telisawebmanagement.entity.PageResult;

import java.util.List;

public interface ClazzService {
    PageResult<Clazz> page(ClazzQueryParam clazzQueryParam);

    void deleteById(Integer id);

    void add(Clazz clazz);

    Clazz getById(Integer id);

    void update(Clazz clazz);

    List<Clazz> list();
}
