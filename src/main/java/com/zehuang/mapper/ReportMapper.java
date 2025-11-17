package com.zehuang.mapper;

import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface ReportMapper {


    /**
     * 统计员工职位人数
     * @return
     */
    @MapKey("pos")
    List<Map<String, Object>> countEmpJobData();

    /**
     * 统计员工性别人数
     * @return
     */
    @MapKey("name")
    List<Map<String, Object>> countGenderData();

    @MapKey("clazzList")
    List<Map<String, Object>> countStudentNumData();

    @MapKey("name")
    List<Map<String, Object>> countStudentDegreeData();
}
