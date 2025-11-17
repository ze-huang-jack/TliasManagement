package com.zehuang.service;

import com.zehuang.pojo.Clazz;
import com.zehuang.pojo.ClazzQueryParam;
import com.zehuang.pojo.PageResult;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ClazzService {

    PageResult<Clazz> page(ClazzQueryParam clazzQueryParam);

    void insert(Clazz clazz);

    Clazz getById(Integer id);

    void update(Clazz clazz);

    void delete(Integer id);

    List<Clazz> getAll();
}
