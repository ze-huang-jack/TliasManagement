package com.zehuang.service;

import com.zehuang.pojo.JobOption;
import com.zehuang.pojo.StudentOption;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface ReportService {

    /**
     * 统计员工职位人数
     * @return
     */
    JobOption countEmpJobData();

    /**
     * 统计员工性别人数
     *
     * @return
     */
    List<Map<String, Object>> countEmpGenderData();

    StudentOption countStudentNumData();

    List<Map<String, Object>> countStudentDegreeData();

}
