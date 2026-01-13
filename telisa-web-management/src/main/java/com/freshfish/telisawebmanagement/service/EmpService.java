package com.freshfish.telisawebmanagement.service;

import com.freshfish.telisawebmanagement.entity.Emp;
import com.freshfish.telisawebmanagement.entity.EmpQueryParam;
import com.freshfish.telisawebmanagement.entity.PageResult;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public interface EmpService {
    PageResult<Emp> page(EmpQueryParam empQueryParam);
//    PageResult<Emp> page(Integer page, Integer pageSize,String name, Integer gender,
//                         LocalDate begin,
//                         LocalDate end);
}
