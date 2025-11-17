package com.zehuang.controller;

import com.zehuang.annotaion.LogOperation;
import com.zehuang.pojo.Clazz;
import com.zehuang.pojo.ClazzQueryParam;
import com.zehuang.pojo.PageResult;
import com.zehuang.pojo.Result;
import com.zehuang.service.ClazzService;
import com.zehuang.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("clazzs")
public class ClazzController {
    @Autowired
    private ClazzService clazzService;
    @Autowired
    private EmpService empService;

    @GetMapping
    public Result page(ClazzQueryParam clazzQueryParam) {
        log.info("分页查询班级: {}", clazzQueryParam);
        PageResult<Clazz> pageResult = clazzService.page(clazzQueryParam);
        return Result.success(pageResult);
    }

    @LogOperation
    @PostMapping
    public Result add(@RequestBody Clazz clazz) {
        log.info("添加班级: {}", clazz);
        clazzService.insert(clazz);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result findById(@PathVariable Integer id) {
        log.info("根据id查询班级: {}", id);
        Clazz clazz = clazzService.getById(id);
        return Result.success(clazz);
    }

    @LogOperation
    @PutMapping
    public Result update(@RequestBody Clazz clazz) {
        log.info("修改班级: {}", clazz);
        clazzService.update(clazz);
        return Result.success();
    }

    @LogOperation
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        log.info("删除班级: {}", id);
        clazzService.delete(id);
        return Result.success();
    }

    @GetMapping("/list")
    public Result findAll() {
        log.info("查询所有班级");
        List<Clazz> clazzList = clazzService.getAll();
        return Result.success(clazzList);
    }
}
