package com.zehuang.service;

import com.zehuang.pojo.Dept;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DeptService {
    /**
     * 查询所有部门信息
     * @return
     */
    List<Dept> findAll();

    /**
     * 删除部门
     * @param deptId
     */
    void deleteById(Integer deptId);

    /**
     * 添加部门
     * @param dept
     */
    void insert(Dept dept);

    /**
     * 根据id查找部门
     * @param deptId
     * @return
     */
    Dept findById(Integer deptId);

    /**
     * 修改部门
     * @param dept
     */
    void update(Dept dept);
}
