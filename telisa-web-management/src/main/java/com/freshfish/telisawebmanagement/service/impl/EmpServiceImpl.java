package com.freshfish.telisawebmanagement.service.impl;

import com.freshfish.telisawebmanagement.entity.Emp;
import com.freshfish.telisawebmanagement.entity.EmpQueryParam;
import com.freshfish.telisawebmanagement.entity.PageResult;
import com.freshfish.telisawebmanagement.mapper.EmpMapper;
import com.freshfish.telisawebmanagement.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpMapper empMapper;

    @Override
    public PageResult<Emp> page(EmpQueryParam empQueryParam){
        Long total = empMapper.getTotal();
        Integer start=(empQueryParam.getPage()-1)*empQueryParam.getPageSize();
        empQueryParam.setStart(start);
        List<Emp> rows = empMapper.getList(empQueryParam);
        PageResult<Emp> pageResult=new PageResult<Emp>();
        pageResult.setTotal(total);
        pageResult.setRows(rows);
        return pageResult;
    }
//    @Override
//    public PageResult<Emp> page(Integer page, Integer pageSize,String name, Integer gender,
//                                LocalDate begin,
//                                LocalDate end){
//        Long total = empMapper.getTotal();
//        Integer start=(page-1)*pageSize;
//        List<Emp> rows = empMapper.getList(start, pageSize, name, gender, begin, end);
//        PageResult<Emp> pageResult=new PageResult<Emp>();
//        pageResult.setTotal(total);
//        pageResult.setRows(rows);
//        return pageResult;
//    }
}
