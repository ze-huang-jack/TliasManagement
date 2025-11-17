package com.zehuang.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zehuang.mapper.StudentMapper;
import com.zehuang.pojo.Clazz;
import com.zehuang.pojo.PageResult;
import com.zehuang.pojo.Student;
import com.zehuang.pojo.StudentQueryParam;
import com.zehuang.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public PageResult<Student> getStudents(StudentQueryParam studentQueryParam) {
        PageHelper.startPage(studentQueryParam.getPage(), studentQueryParam.getPageSize());
        List<Student> studentList = studentMapper.selectAllStudents(studentQueryParam);
        PageInfo<Student> pageInfo = new PageInfo<Student>(studentList);
        return PageResult.of(pageInfo);
    }

    @Override
    public void insertStudent(Student student) {
        student.setCreateTime(LocalDateTime.now());
        student.setUpdateTime(LocalDateTime.now());
        studentMapper.insertStudent(student);
    }

    @Override
    public Student getById(Integer id) {
        return studentMapper.selectById(id);
    }

    @Override
    public void updateStudent(Student student) {
        student.setUpdateTime(LocalDateTime.now());
        studentMapper.updateStudent(student);
    }

    @Override
    public void deleteStudent(List<Integer> ids) {
        studentMapper.deleteStudent(ids);
    }

    @Override
    public void handleViolation(Integer id, Short score) {
        Student student = studentMapper.selectById(id);
        if (student == null) {
            throw new RuntimeException("学生不存在");
        }
        Short currentCount = student.getViolationCount() == null ? 0 : student.getViolationCount();
        student.setViolationCount((short) (currentCount + 1));

        Short currentScore = student.getViolationScore() == null ? 0 : student.getViolationScore();
        student.setViolationScore((short) (currentScore + score));

        student.setUpdateTime(LocalDateTime.now());
        studentMapper.updateStudent(student);
    }
}
