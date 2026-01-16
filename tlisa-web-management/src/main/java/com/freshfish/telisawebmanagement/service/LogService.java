package com.freshfish.telisawebmanagement.service;

import com.freshfish.telisawebmanagement.entity.Log;

import java.util.List;

public interface LogService {
    List<Log> page(Integer page, Integer pageSize);
}
