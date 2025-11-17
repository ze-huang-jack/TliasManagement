package com.zehuang.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClazzQueryParam {
    private String name;
    private Integer page = 1;
    private Integer pageSize = 10;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    LocalDate begin;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    LocalDate end;
}
