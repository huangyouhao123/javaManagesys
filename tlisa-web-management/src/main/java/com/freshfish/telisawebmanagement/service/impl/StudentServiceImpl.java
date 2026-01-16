package com.freshfish.telisawebmanagement.service.impl;

import com.freshfish.telisawebmanagement.entity.PageResult;
import com.freshfish.telisawebmanagement.entity.Student;
import com.freshfish.telisawebmanagement.entity.StudentQueryParam;
import com.freshfish.telisawebmanagement.mapper.StudentMapper;
import com.freshfish.telisawebmanagement.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;

    @Override
    public PageResult<Student> list(StudentQueryParam studentQueryParam) {
        Long total = studentMapper.getTotal();
        Integer start=(studentQueryParam.getPage()-1)*studentQueryParam.getPageSize();
        studentQueryParam.setStart(start);
        List<Student> rows = studentMapper.getList(studentQueryParam);
        PageResult<Student> pageResult=new PageResult<Student>();
        pageResult.setTotal(total);
        pageResult.setRows(rows);
        return pageResult;
    }

    @Override
    public void deleteByIds(Integer[] ids) {
        studentMapper.deleteByIds(ids);
    }

    @Override
    public void insert(Student student) {
        student.setUpdateTime(LocalDateTime.now());
        student.setCreateTime(LocalDateTime.now());
        student.setViolationCount((short) 0);
        student.setViolationScore((short) 0);
        studentMapper.insert(student);
    }

    @Override
    public Student getById(Integer id) {
        return studentMapper.getById(id);
    }

    @Override
    public void update(Student student) {
        student.setUpdateTime(LocalDateTime.now());
        studentMapper.update(student);
    }

    @Override
    public void updateViolation(Integer id, Short score) {
        Student student = studentMapper.getById(id);
        student.setViolationScore((short) (student.getViolationScore()+score));
        student.setViolationCount((short) (student.getViolationCount()+1));
        student.setUpdateTime(LocalDateTime.now());
        studentMapper.updateVoilation(student);
    }
}
