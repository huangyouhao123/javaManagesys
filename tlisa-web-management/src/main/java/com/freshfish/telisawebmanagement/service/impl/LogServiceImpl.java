package com.freshfish.telisawebmanagement.service.impl;
import com.freshfish.telisawebmanagement.entity.Log;
import com.freshfish.telisawebmanagement.mapper.LogMapper;
import com.freshfish.telisawebmanagement.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogServiceImpl implements LogService {

    @Autowired
    private LogMapper logMapper;

    @Override
    public List<Log> page(Integer page, Integer pageSize) {
        Integer start = (page - 1) * pageSize;
        return logMapper.page(start, pageSize);
    }
}
