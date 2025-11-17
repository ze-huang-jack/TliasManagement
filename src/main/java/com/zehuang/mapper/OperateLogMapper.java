package com.zehuang.mapper;

import com.zehuang.pojo.OperateLog;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OperateLogMapper {

    public void insert(OperateLog operateLog);

    public List<OperateLog> selectAll();
}
