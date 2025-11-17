package com.zehuang.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zehuang.mapper.OperateLogMapper;
import com.zehuang.pojo.OperateLog;
import com.zehuang.pojo.PageResult;
import com.zehuang.service.OperationLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OperationLogServiceImpl implements OperationLogService {
    @Autowired
    private OperateLogMapper operateLogMapper;

    public PageResult<OperateLog> findAll(Integer page, Integer pageSize) {
        PageHelper.startPage(page, pageSize);
        List<OperateLog> list = operateLogMapper.selectAll();
        PageInfo<OperateLog> pageInfo = new PageInfo<>(list);
        return PageResult.of(pageInfo);

    }
}
