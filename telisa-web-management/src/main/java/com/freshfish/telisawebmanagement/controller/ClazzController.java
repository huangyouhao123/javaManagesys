package com.freshfish.telisawebmanagement.controller;

import com.freshfish.telisawebmanagement.entity.Clazz;
import com.freshfish.telisawebmanagement.entity.ClazzQueryParam;
import com.freshfish.telisawebmanagement.entity.PageResult;
import com.freshfish.telisawebmanagement.entity.Result;
import com.freshfish.telisawebmanagement.service.ClazzService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/clazzs")
public class ClazzController {

    @Autowired
    private ClazzService clazzService;

    @GetMapping
    public Result page(ClazzQueryParam clazzQueryParam){
        log.info("分页查询,参数: {}", clazzQueryParam);
        PageResult<Clazz> pageResult=clazzService.page(clazzQueryParam);
        return Result.success(pageResult);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id){
        log.info("删除班级,id: {}", id);
        clazzService.deleteById(id);
        return Result.success(null);
    }

    @PostMapping
    public Result add(@RequestBody Clazz clazz){
        log.info("添加班级,参数: {}", clazz);
        clazzService.add(clazz);
        return Result.success(null);
    }

    @GetMapping("/{id}")
    public Result get(@PathVariable Integer id){
        log.info("查询班级,id: {}", id);
        Clazz clazz = clazzService.getById(id);
        return Result.success(clazz);
    }

    @PutMapping
    public Result update(@RequestBody Clazz clazz){
        log.info("更新班级,参数: {}", clazz);
        clazzService.update(clazz);
        return Result.success(null);
    }

    @GetMapping("/list")
    public Result list(){
        log.info("查询班级列表");
        List<Clazz> list = clazzService.list();
        return Result.success(list);
    }
}
