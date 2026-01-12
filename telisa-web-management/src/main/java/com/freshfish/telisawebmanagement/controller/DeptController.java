package com.freshfish.telisawebmanagement.controller;

import com.freshfish.telisawebmanagement.entity.Dept;
import com.freshfish.telisawebmanagement.entity.Result;
import com.freshfish.telisawebmanagement.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;

    @RequestMapping(value = "/depts",method = RequestMethod.GET)
    public Result list() {
        System.out.println("查询全部部门数据");
        List<Dept> depts =  deptService.findAll();
        return Result.success(depts);
    }
}
