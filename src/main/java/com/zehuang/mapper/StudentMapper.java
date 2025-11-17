package com.zehuang.mapper;

import com.zehuang.pojo.Student;
import com.zehuang.pojo.StudentOption;
import com.zehuang.pojo.StudentQueryParam;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface StudentMapper {

    List<Student> selectAllStudents(StudentQueryParam studentQueryParam);

    void insertStudent(Student student);

    Student selectById(Integer id);

    void updateStudent(Student student);

    void deleteStudent(List<Integer> ids);

}
