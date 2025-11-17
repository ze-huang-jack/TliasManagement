package com.zehuang.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentOption {
    private List clazzlist; // 班级列表
    private List dataList; // 数据列表
}
