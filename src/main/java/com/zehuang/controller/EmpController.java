package com.zehuang.controller;

import com.zehuang.annotaion.LogOperation;
import com.zehuang.pojo.Emp;
import com.zehuang.pojo.EmpQueryParam;
import com.zehuang.pojo.PageResult;
import com.zehuang.pojo.Result;
import com.zehuang.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/emps")
@Slf4j
public class EmpController {

    @Autowired
    private EmpService empService;

    @GetMapping
    public Result page(EmpQueryParam empQueryParam) {
        log.info("分页查询: {}", empQueryParam);
        PageResult<Emp> pageResult = empService.page(empQueryParam);
        return Result.success(pageResult);
    }
    @LogOperation
    @PostMapping
    public Result save(@RequestBody Emp emp) {
        log.info("新增员工: {}", emp);
        empService.save(emp);
        return Result.success();
    }
    @LogOperation
    @DeleteMapping
    public Result delete(@RequestParam List<Integer> ids) {
        log.info("批量删除员工: {}", ids);
        empService.delete(ids);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id) {
        log.info("根据id查询员工: {}", id);
        Emp emp = empService.getById(id);
        return Result.success(emp);
    }
    @LogOperation
    @PutMapping
    public Result update(@RequestBody Emp emp) {
        log.info("修改员工: {}", emp);
        empService.update(emp);
        return Result.success();
    }

    @GetMapping("/list")
    public Result selectAll() {
        log.info("查询全部员工");
        List<Emp> empList = empService.selectAll();
        return Result.success(empList);
    }


}
