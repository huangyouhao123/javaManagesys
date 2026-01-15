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

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;

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

    @DeleteMapping
    public Result delete(Integer[] ids){
        log.info("删除员工,员工id: {}", Arrays.toString(ids));
        empService.deleteByIds(ids);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result getInfo(@PathVariable("id") Integer id){
        log.info("查询员工数据{}", id);
        Emp emp =  empService.getById(id);
        return Result.success(emp);
    }

    @PutMapping
    public Result update(@RequestBody Emp emp){
        log.info("更新员工,员工信息: {}", emp);
        empService.update(emp);
        return Result.success();
    }
}
