package com.zehuang.mapper;

import com.zehuang.pojo.Clazz;
import com.zehuang.pojo.ClazzQueryParam;
import com.zehuang.pojo.PageResult;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ClazzMapper {


    List<Clazz> list(ClazzQueryParam clazzQueryParam);

    void insert(Clazz clazz);

    Clazz getById(Integer id);

    void update(Clazz clazz);

    void delete(Integer id);

    List<Clazz> selectAll();
}
