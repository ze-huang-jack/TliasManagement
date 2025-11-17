package com.zehuang.controller;

import com.zehuang.pojo.PageResult;
import com.zehuang.pojo.Result;
import com.zehuang.pojo.Student;
import com.zehuang.pojo.StudentQueryParam;
import com.zehuang.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
@Slf4j
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping
    public Result page(StudentQueryParam studentQueryParam) {
        log.info("分页查询学员： {}", studentQueryParam );
        PageResult<Student> pageResult = studentService.getStudents(studentQueryParam);
        return Result.success(pageResult);
    }

    @PostMapping
    public Result save(@RequestBody Student student) {
        log.info("添加学员： {}", student);
        studentService.insertStudent(student);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result getStudent(@PathVariable Integer id) {
        log.info("根据id查询学员: {}", id);
        Student student = studentService.getById(id);
        return Result.success(student);
    }

    @PutMapping
    public Result update(@RequestBody Student student) {
        log.info("修改学员: {}", student);
        studentService.updateStudent(student);
        return Result.success();
    }

    @DeleteMapping("/{ids}")
    public Result delete(@PathVariable List<Integer> ids) {
        log.info("批量删除学生: {}", ids);
        studentService.deleteStudent(ids);
        return Result.success();
    }

    @PutMapping("/violation/{id}/{score}")
    public Result violation(@PathVariable Integer id, @PathVariable Short score) {
        log.info("违纪处理: {} {}", id , score);
        studentService.handleViolation(id, score);
        return Result.success();
    }

}
