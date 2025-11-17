package com.zehuang.controller;

import com.zehuang.mapper.OperateLogMapper;
import com.zehuang.pojo.OperateLog;
import com.zehuang.pojo.PageResult;
import com.zehuang.pojo.Result;
import com.zehuang.service.OperationLogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class OperationLogController {
    @Autowired
    private OperationLogService operationLogService;

    @GetMapping("/log/page")
    public Result page(Integer page, Integer pageSize) {
        log.info("分页查询操作日志: {} {}", page, pageSize);
        PageResult<OperateLog> logs = operationLogService.findAll(page, pageSize);
        return Result.success(logs);
    }
}
