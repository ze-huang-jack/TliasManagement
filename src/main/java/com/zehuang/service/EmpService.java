package com.zehuang.service;

import com.zehuang.pojo.Emp;
import com.zehuang.pojo.EmpQueryParam;
import com.zehuang.pojo.LoginInfo;
import com.zehuang.pojo.PageResult;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface EmpService {

    /**
     * 分页查询
     * @param empQueryParam
     * @return
     */
    PageResult<Emp> page(EmpQueryParam empQueryParam);

    /**
     * 新增员工
     * @param emp
     */
    void save(Emp emp);

    /**
     * 删除员工
     * @param ids
     */
    void delete(List<Integer> ids);

    /**
     * 根据id查询员工
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
     * 根据用户名和明码查询员工信息
     * @param emp
     * @return
     */
    LoginInfo login(Emp emp);
}
