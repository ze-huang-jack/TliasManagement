package com.zehuang.service;

import com.zehuang.pojo.OperateLog;
import com.zehuang.pojo.PageResult;
import org.springframework.stereotype.Service;

@Service
public interface OperationLogService {

    PageResult<OperateLog> findAll(Integer page, Integer pageSize);
}
