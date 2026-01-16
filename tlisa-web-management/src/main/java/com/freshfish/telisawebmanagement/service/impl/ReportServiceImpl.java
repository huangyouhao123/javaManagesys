package com.freshfish.telisawebmanagement.service.impl;

import com.freshfish.telisawebmanagement.entity.JobOption;
import com.freshfish.telisawebmanagement.entity.StudentOption;
import com.freshfish.telisawebmanagement.mapper.EmpMapper;
import com.freshfish.telisawebmanagement.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.freshfish.telisawebmanagement.service.ReportService;
import java.util.Map;
import java.util.List;

@Service
public class ReportServiceImpl implements ReportService{
    @Autowired
    private EmpMapper empMapper;
    @Autowired
    private StudentMapper studentMapper;


    @Override
    public JobOption countEmpJobData() {
        List<Map<String, Object>> list = empMapper.countEmpJobData();
        List<Object> jobList = list.stream().map(dataMap->dataMap.get("pos")).toList();
        List<Object> dataList = list.stream().map(dataMap->dataMap.get("num")).toList();
        return new JobOption(jobList, dataList);
    }

    @Override
    public List<Map<String, Object>> countEmpGenderData() {
        return empMapper.countEmpGenderData();
    }

    @Override
    public List<Map<String, Object>> countStudentDegreeData() {
        return studentMapper.countStudentDegreeData();
    }

    @Override
    public StudentOption countStudentCountData() {
        List<Map<String, Object>> list = studentMapper.countStudentData();
        List<Object> clazzList = list.stream().map(dataMap->dataMap.get("clazz_name")).toList();
        List<Object> dataList = list.stream().map(dataMap->dataMap.get("student_count")).toList();
        return new StudentOption(clazzList, dataList);
    }
}
