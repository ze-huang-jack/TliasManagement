package com.zehuang.mapper;

import com.zehuang.pojo.Emp;
import com.zehuang.pojo.EmpQueryParam;
import org.apache.ibatis.annotations.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Mapper
public interface EmpMapper {
    /**
     *条件查询员工信息
     * @return
     */
    public List<Emp> list(EmpQueryParam empQueryParam);

    /**
     * 新增员工基本信息
     * @param emp
     */
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(Emp emp);

    /**
     * 删除员工
     * @param ids
     */
    void delete(List<Integer> ids);

    /**
     * 根据id查询员工(包括员工经历）
     * @param id
     * @return
     */
    Emp getById(Integer id);

    /**
     * 修改员工
     * @param emp
     */
    void update(Emp emp);

    /**
     * 查询全部员工
     */
    List<Emp> selectAll();

    /**
     * 根据用户名和密码查询员工信息
     * @param emp
     * @return
     */
    Emp getByUsernameAndPassword(Emp emp);
}





















