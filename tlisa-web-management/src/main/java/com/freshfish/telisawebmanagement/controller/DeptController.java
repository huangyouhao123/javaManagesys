package com.freshfish.telisawebmanagement.controller;

import com.freshfish.telisawebmanagement.entity.Dept;
import com.freshfish.telisawebmanagement.entity.Result;
import com.freshfish.telisawebmanagement.service.DeptService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/depts")
@RestController
@Slf4j
public class DeptController {

    @Autowired
    private DeptService deptService;

    @RequestMapping(method = RequestMethod.GET)
    public Result list() {
        log.info("查询全部部门数据");
        List<Dept> depts =  deptService.findAll();
        return Result.success(depts);
    }

    // delete
    @DeleteMapping
    public Result delete(Integer id) {
        log.info("删除部门数据{}", id);
        deptService.deleteById(id);
        return Result.success();
    }

    //add
    @PostMapping
    public Result add(@RequestBody Dept dept){
        log.info("添加部门数据{}", dept);
        deptService.add(dept);
        return Result.success();
    }

    //query
    @GetMapping("/{id}")
    public Result getInfo(@PathVariable("id") Integer id){
        log.info("查询部门数据{}", id);
        Dept dept =  deptService.getInfo(id);
        return Result.success(dept);
    }

    @PutMapping
    public Result update(@RequestBody Dept dept){
        log.info("更新部门数据{}", dept);
        deptService.update(dept);
        return Result.success();
    }
}
