package com.zehuang.pojo;

import com.github.pagehelper.PageHelper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmpQueryParam {
    private Integer page = 1;
    private Integer pageSize = 10;
    private String name;
    private String gender;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    LocalDate begin;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    LocalDate end;
}
