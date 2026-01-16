package com.freshfish.telisawebmanagement.service;

import com.freshfish.telisawebmanagement.entity.PageResult;
import com.freshfish.telisawebmanagement.entity.Student;
import com.freshfish.telisawebmanagement.entity.StudentQueryParam;

public interface StudentService {
    PageResult<Student> list(StudentQueryParam studentQueryParam);

    void deleteByIds(Integer[] ids);

    void insert(Student student);

    Student getById(Integer id);

    void update(Student student);

    void updateViolation(Integer id, Short score);
}
