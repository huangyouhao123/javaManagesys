package com.freshfish.telisawebmanagement.service;

import com.freshfish.telisawebmanagement.entity.JobOption;
import com.freshfish.telisawebmanagement.entity.StudentOption;

import java.util.List;
import java.util.Map;

public interface ReportService {
    JobOption countEmpJobData();

    List<Map<String, Object>> countEmpGenderData();

    List<Map<String, Object>> countStudentDegreeData();

    StudentOption countStudentCountData();
}
