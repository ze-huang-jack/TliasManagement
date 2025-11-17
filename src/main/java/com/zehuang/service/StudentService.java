package com.zehuang.service;

import com.zehuang.pojo.PageResult;
import com.zehuang.pojo.Student;
import com.zehuang.pojo.StudentQueryParam;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {

    PageResult<Student> getStudents(StudentQueryParam studentQueryParam);

    void insertStudent(Student student);

    Student getById(Integer id);

    void updateStudent(Student student);

    void deleteStudent(List<Integer> ids);

    void handleViolation(Integer id, Short score);
}
