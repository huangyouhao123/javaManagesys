package com.freshfish.telisawebmanagement.service.impl;

import com.freshfish.telisawebmanagement.mapper.EmpLogMapper;
import com.freshfish.telisawebmanagement.entity.EmpLog;
import com.freshfish.telisawebmanagement.service.EmpLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmpLogServiceImpl implements EmpLogService {

    @Autowired
    private EmpLogMapper empLogMapper;

    @Transactional(propagation = Propagation.REQUIRES_NEW)  // 需要在新事务中运行
    @Override
    public void insertLog(EmpLog empLog) {
        empLogMapper.insert(empLog);
    }
}
