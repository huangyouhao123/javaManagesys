package com.freshfish.telisawebmanagement.service;

import com.freshfish.telisawebmanagement.entity.Dept;

import java.util.List;

public interface DeptService {
    // 增加
    List<Dept> findAll();
    // 删除
    void deleteById(Integer id);

    void add(Dept dept);

    Dept getInfo(Integer id);

    void update(Dept dept);
}
