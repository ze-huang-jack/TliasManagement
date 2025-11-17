package com.zehuang.service.impl;

import com.zehuang.mapper.EmpMapper;
import com.zehuang.mapper.ReportMapper;
import com.zehuang.mapper.StudentMapper;
import com.zehuang.pojo.JobOption;
import com.zehuang.pojo.StudentOption;
import com.zehuang.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReportServiceImpl implements ReportService {

    @Autowired
    private EmpMapper empMapper;
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private ReportMapper reportMapper;

    @Override
    public JobOption countEmpJobData() {
        List<Map<String, Object>> list = reportMapper.countEmpJobData();
        List<Object> jobList = list.stream().map(dataMap -> dataMap.get("pos")).toList();
        List<Object> dataList = list.stream().map(dataMap -> dataMap.get("num")).toList();
        return new JobOption(jobList, dataList);
    }

    @Override
    public List<Map<String, Object>> countEmpGenderData() {
        return reportMapper.countGenderData();
    }

    @Override
    public StudentOption countStudentNumData() {
        List<Map<String, Object>> maps = reportMapper.countStudentNumData();
        List<Object> clazzList = maps.stream().map(m -> m.get("clazzList")).toList();
        List<Object> dataList = maps.stream().map(m -> m.get("dataList")).toList();
        return new StudentOption(clazzList, dataList);
    }

    @Override
    public List<Map<String, Object>> countStudentDegreeData() {
        return reportMapper.countStudentDegreeData();
    }
}
