package com.freshfish.telisawebmanagement.controller;

import com.freshfish.telisawebmanagement.entity.Emp;
import com.freshfish.telisawebmanagement.entity.EmpQueryParam;
import com.freshfish.telisawebmanagement.entity.PageResult;
import com.freshfish.telisawebmanagement.entity.Result;
import com.freshfish.telisawebmanagement.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@RestController
@Slf4j
@RequestMapping("/emps")
public class EmpController {

    @Autowired
    private EmpService empService;

    @GetMapping()
    public Result page(EmpQueryParam empQueryParam){
        log.info("分页查询,参数: {}", empQueryParam);
        PageResult<Emp> pageResult=empService.page(empQueryParam);
        return Result.success(pageResult);
    }

    @PostMapping
    public Result save(@RequestBody Emp emp){  // @RequestBody 表示接收json数据，（get类型不需要）
        log.info("保存员工,员工信息: {}", emp);
        empService.save(emp);
        return Result.success();
    }

}
