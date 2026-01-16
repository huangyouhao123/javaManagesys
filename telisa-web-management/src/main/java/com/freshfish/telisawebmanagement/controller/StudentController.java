package com.freshfish.telisawebmanagement.controller;

import com.freshfish.telisawebmanagement.entity.PageResult;
import com.freshfish.telisawebmanagement.entity.Result;
import com.freshfish.telisawebmanagement.entity.Student;
import com.freshfish.telisawebmanagement.entity.StudentQueryParam;
import com.freshfish.telisawebmanagement.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService studentService;
    /**
     * 获取学生列表
     * @return
     */
    @GetMapping
    public Result list(StudentQueryParam studentQueryParam){
        log.info("获取学生列表");
        PageResult<Student> pageResult= studentService.list(studentQueryParam);
        return Result.success(pageResult);
    }

    @DeleteMapping("/{ids}")
    public Result delete(@PathVariable Integer[] ids){
        log.info("删除学生");
        studentService.deleteByIds(ids);
        return Result.success();
    }

    @PostMapping
    public Result add(@RequestBody Student student){
        log.info("保存学生");
        studentService.insert(student);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result get(@PathVariable Integer id){
        log.info("查询学生,id: {}", id);
        Student student = studentService.getById(id);
        return Result.success(student);
    }

    @PutMapping
    public Result update(@RequestBody Student student){
        log.info("更新学生");
        studentService.update(student);
        return Result.success();
    }

    @PutMapping("/violation/{id}/{score}")
    public Result updateViolation(@PathVariable Integer id, @PathVariable Short score){
        log.info("更新学生违纪信息");
        studentService.updateViolation(id,score);
        return Result.success();
    }
}
