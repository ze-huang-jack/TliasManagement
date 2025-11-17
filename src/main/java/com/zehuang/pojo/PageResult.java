package com.zehuang.pojo;

import com.github.pagehelper.PageInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageResult<T> {
    private Long total;
    private List<T> rows;

    public static <T> PageResult<T> of(PageInfo<T> pageInfo) {
        return new PageResult<>(pageInfo.getTotal(), pageInfo.getList());
    }
}
