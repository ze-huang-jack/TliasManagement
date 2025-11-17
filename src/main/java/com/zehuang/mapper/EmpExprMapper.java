package com.zehuang.mapper;

import com.zehuang.pojo.Emp;
import com.zehuang.pojo.EmpExpr;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface EmpExprMapper {

    /**
     * 批量保存员工工作信息
     * @param exprList
     */
    void insertBatch(List<EmpExpr> exprList);

    /**
     * 删除员工经历
     * @param ids
     */
    void delete(List<Integer> ids);
}
