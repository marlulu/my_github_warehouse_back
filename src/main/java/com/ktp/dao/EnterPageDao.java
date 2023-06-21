package com.ktp.dao;

import com.ktp.entity.StudentEntity;
import com.ktp.entity.TeacherEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
@Repository
@Mapper
public interface EnterPageDao {
    StudentEntity getStudent(@Param("username") String username);

    TeacherEntity getTeacher(@Param("username") String username);

    Integer registTeacher(TeacherEntity teacherEntity);

    Integer registStudent(StudentEntity studentEntity);

}
