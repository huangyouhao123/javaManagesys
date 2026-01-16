package com.freshfish.telisawebmanagement.controller;

import com.freshfish.telisawebmanagement.entity.JobOption;
import com.freshfish.telisawebmanagement.entity.Result;
import com.freshfish.telisawebmanagement.entity.StudentOption;
import com.freshfish.telisawebmanagement.service.ReportService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@Slf4j
@RequestMapping("/report")
@RestController
public class ReportController {

    @Autowired
    private ReportService reportService;

    /**
     * 生成员工工作统计数据
     */
    @GetMapping("/empJobData")
    public Result getEmpJobData(){
        log.info("生成员工工作统计数据");
        JobOption jobOption= reportService.countEmpJobData();
        return Result.success(jobOption);
    }

    @GetMapping("/empGenderData")
    public Result getGenderData(){
        log.info("生成员工性别统计数据");
        List<Map<String, Object>> genderData = reportService.countEmpGenderData();
        return Result.success(genderData);
    }

    @GetMapping("/studentDegreeData")
    public Result getStudentDegreeData(){
        log.info("生成学生学历统计数据");
        List<Map<String, Object>> degreeData = reportService.countStudentDegreeData();
        return Result.success(degreeData);
    }

    @GetMapping("/studentCountData")
    public Result getStudentCountData(){
        log.info("生成学生学历统计数据");
        StudentOption countData = reportService.countStudentCountData();
        return Result.success(countData);
    }

}
