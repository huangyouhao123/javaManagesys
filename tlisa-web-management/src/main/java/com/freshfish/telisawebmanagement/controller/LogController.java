package com.freshfish.telisawebmanagement.controller;

import com.freshfish.telisawebmanagement.entity.Log;
import com.freshfish.telisawebmanagement.entity.LogQueryParam;
import com.freshfish.telisawebmanagement.entity.Result;
import com.freshfish.telisawebmanagement.service.LogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
public class LogController {
    /**
     * 测试日志
     */
    @Autowired
    private LogService logService;

    @GetMapping("/log/page")
    public Result page(LogQueryParam  param){
        Integer page = param.getPage();
        Integer pageSize = param.getPageSize();
        log.info("测试日志");
        List<Log> list = logService.page(page, pageSize);
        return Result.success(list);
    }

}
