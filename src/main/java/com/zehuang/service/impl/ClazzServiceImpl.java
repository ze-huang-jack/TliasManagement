package com.zehuang.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zehuang.mapper.ClazzMapper;
import com.zehuang.pojo.Clazz;
import com.zehuang.pojo.ClazzQueryParam;
import com.zehuang.pojo.PageResult;
import com.zehuang.service.ClazzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ClazzServiceImpl implements ClazzService {
    @Autowired
    private  ClazzMapper clazzMapper;

    @Override
    public PageResult<Clazz> page(ClazzQueryParam clazzQueryParam) {
        PageHelper.startPage(clazzQueryParam.getPage(), clazzQueryParam.getPageSize());
        List<Clazz> clazzList = clazzMapper.list(clazzQueryParam);

        LocalDate now = LocalDate.now();
        for(Clazz clazz : clazzList) {
            if (now.isBefore(clazz.getBeginDate())) {
                clazz.setStatus("未开班");
                continue;
            }
            if (now.isAfter(clazz.getEndDate())) {
                clazz.setStatus("已结课");
                continue;
            }
            clazz.setStatus("在读中");
        }

        PageInfo<Clazz> pageInfo = new PageInfo<>(clazzList);
        return PageResult.of(pageInfo);
    }

    @Override
    public void insert(Clazz clazz) {
        clazz.setCreateTime(LocalDateTime.now());
        clazz.setUpdateTime(LocalDateTime.now());
        clazzMapper.insert(clazz);
    }

    @Override
    public Clazz getById(Integer id) {
        return clazzMapper.getById(id);
    }

    @Override
    public void update(Clazz clazz) {
        clazz.setUpdateTime(LocalDateTime.now());
        clazzMapper.update(clazz);
    }

    @Override
    public void delete(Integer id) {
        clazzMapper.delete(id);
    }

    @Override
    public List<Clazz> getAll() {
        return clazzMapper.selectAll();
    }


}
