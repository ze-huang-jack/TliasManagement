package com.zehuang.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zehuang.mapper.EmpExprMapper;
import com.zehuang.mapper.EmpMapper;
import com.zehuang.pojo.*;
import com.zehuang.service.EmpService;
import com.zehuang.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpMapper empMapper;

    @Autowired
    private EmpExprMapper empExprMapper;

    @Override
    public PageResult<Emp> page(EmpQueryParam empQueryParam) {
        PageHelper.startPage(empQueryParam.getPage(), empQueryParam.getPageSize());
        List<Emp> empList = empMapper.list(empQueryParam);
        PageInfo<Emp> pageInfo = new PageInfo<>(empList);
        return PageResult.of(pageInfo);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(Emp emp) {
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.insert(emp);

        List<EmpExpr> exprList = emp.getExprList();
        if (!CollectionUtils.isEmpty(exprList)) {
            for (EmpExpr expr : exprList) {
                expr.setEmpId(emp.getId());
            }
            empExprMapper.insertBatch(exprList);
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(List<Integer> ids) {
        empMapper.delete(ids);
        empExprMapper.delete(ids);
    }

    @Override
    public Emp getById(Integer id) {
        return empMapper.getById(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(Emp emp) {
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.update(emp);

        empExprMapper.delete(Collections.singletonList(emp.getId()));
        List<EmpExpr> exprList = emp.getExprList();
        if (!CollectionUtils.isEmpty(exprList)) {
            exprList.forEach(expr -> expr.setEmpId(emp.getId()));
            empExprMapper.insertBatch(exprList);
        }
    }

    @Override
    public List<Emp> selectAll() {
        return empMapper.selectAll();
    }

    @Override
    public LoginInfo login(Emp emp) {
        Emp empLogin = empMapper.getByUsernameAndPassword(emp);
        if(empLogin != null) {
            Map<String, Object> dataMap = new HashMap<>();
            dataMap.put("id", empLogin.getId());
            dataMap.put("username", empLogin.getUsername());
            String jwt = JwtUtils.generateJwt(dataMap);
            return new LoginInfo(empLogin.getId(), empLogin.getUsername(), empLogin.getName(), empLogin.getPassword(), jwt);
        }
        return null;
    }

}
