package com.freshfish.telisawebmanagement.service.impl;

import com.freshfish.telisawebmanagement.entity.Dept;
import com.freshfish.telisawebmanagement.mapper.DeptMapper;
import com.freshfish.telisawebmanagement.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptMapper deptMapper;

    @Override
    public List<Dept> findAll() {
        return deptMapper.findAll();
    }
}
