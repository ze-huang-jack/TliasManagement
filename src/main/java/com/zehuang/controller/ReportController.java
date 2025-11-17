package com.zehuang.controller;

import com.zehuang.pojo.JobOption;
import com.zehuang.pojo.Result;
import com.zehuang.pojo.StudentOption;
import com.zehuang.service.EmpService;
import com.zehuang.service.ReportService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/report")
@Slf4j
public class ReportController {
    @Autowired
    private ReportService reportService;

    @GetMapping("/empJobData")
    private Result countEmpJobData() {
        log.info("统计员工职位人数");
        JobOption jobOption = reportService.countEmpJobData();
        return Result.success(jobOption);
    }

    @GetMapping("/empGenderData")
    private Result countEmpGenderData() {
        log.info("统计员工性别人数");
        List<Map<String, Object>> maps = reportService.countEmpGenderData();
        return Result.success(maps);
    }

    @GetMapping("/studentCountData")
    private Result countStudentNumData() {
        log.info("统计学员人数");
        StudentOption studentOption = reportService.countStudentNumData();
        return Result.success(studentOption);
    }

    @GetMapping("/studentDegreeData")
    private Result countStudentDegreeData() {
        log.info("统计学员学历人数");
        List<Map<String, Object>> maps = reportService.countStudentDegreeData();
        return Result.success(maps);
    }

}
