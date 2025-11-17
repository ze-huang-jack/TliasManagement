package com.zehuang.controller;

import com.zehuang.annotaion.LogOperation;
import com.zehuang.pojo.Dept;
import com.zehuang.pojo.Result;
import com.zehuang.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/depts")
@Slf4j
public class DeptController {

    @Autowired
    private DeptService deptService;

    @GetMapping
    public Result list() {
        log.info("查询全部部门数据");
        List<Dept> deptList = deptService.findAll();
        return Result.success(deptList);
    }
    @LogOperation
    @DeleteMapping
    public Result delete(@RequestParam(value = "id", required = true) Integer deptId) {
        log.info("根据id删除部门: {}", deptId);
        deptService.deleteById(deptId);
        return Result.success();
    }
    @LogOperation
    @PostMapping
    public Result save(@RequestBody Dept dept) {
        log.info("添加部门: {}", dept);
        deptService.insert(dept);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result findById(@PathVariable("id") Integer deptId) {
        log.info("根据id查询部门数据: {}", deptId);
        Dept dept = deptService.findById(deptId);
        return Result.success(dept);
    }
    @LogOperation
    @PutMapping
    public Result update(@RequestBody Dept dept) {
        log.info("修改部门: {}", dept);
        deptService.update(dept);
        return Result.success();

    }

}
