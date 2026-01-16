package com.freshfish.telisawebmanagement.service.impl;

import com.freshfish.telisawebmanagement.entity.Clazz;
import com.freshfish.telisawebmanagement.entity.ClazzQueryParam;
import com.freshfish.telisawebmanagement.entity.Clazz;
import com.freshfish.telisawebmanagement.entity.PageResult;
import com.freshfish.telisawebmanagement.mapper.ClazzMapper;
import com.freshfish.telisawebmanagement.mapper.EmpMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.freshfish.telisawebmanagement.service.ClazzService;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ClazzServiceImpl implements ClazzService{
    @Autowired
    private ClazzMapper clazzMapper;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public PageResult<Clazz> page(ClazzQueryParam clazzQueryParam) {
        Long total = clazzMapper.getTotal();
        Integer start=(clazzQueryParam.getPage()-1)*clazzQueryParam.getPageSize();
        clazzQueryParam.setStart(start);

        List<Clazz> rows = clazzMapper.getList(clazzQueryParam);

        rows.forEach(clazz -> clazz.setStatus(clazz.getEndDate().isBefore(LocalDate.now()) ?"已结课":"在读"));
        PageResult<Clazz> pageResult=new PageResult<Clazz>();
        pageResult.setTotal(total);
        pageResult.setRows(rows);

        return pageResult;
    }

    @Override
    public void deleteById(Integer id) {
        clazzMapper.deleteById(id);
    }

    @Override
    public void add(Clazz clazz) {
        clazz.setCreateTime(LocalDateTime.now());
        clazz.setUpdateTime(LocalDateTime.now());
        clazzMapper.insert(clazz);
    }

    @Override
    public Clazz getById(Integer id) {
        Clazz clazz = clazzMapper.getById(id);
        clazz.setStatus(clazz.getEndDate().isBefore(LocalDate.now()) ?"已结课":"在读");

        return clazz;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void update(Clazz clazz) {
        clazz.setUpdateTime(LocalDateTime.now());
        clazzMapper.updateById(clazz);
    }

    @Override
    public List<Clazz> list() {
        return clazzMapper.list();
    }
}
