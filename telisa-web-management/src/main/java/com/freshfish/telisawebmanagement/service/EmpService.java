package com.freshfish.telisawebmanagement.service;

import com.freshfish.telisawebmanagement.entity.Emp;
import com.freshfish.telisawebmanagement.entity.EmpQueryParam;
import com.freshfish.telisawebmanagement.entity.PageResult;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public interface EmpService {
    PageResult<Emp> page(EmpQueryParam empQueryParam);

    void save(Emp emp);

}
