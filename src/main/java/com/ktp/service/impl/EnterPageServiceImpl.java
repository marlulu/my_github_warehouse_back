package com.ktp.service.impl;

import com.ktp.dao.EnterPageDao;
import com.ktp.entity.StudentEntity;
import com.ktp.entity.TeacherEntity;
import com.ktp.request.RegistRequest;
import com.ktp.response.UserResponse;
import com.ktp.service.EnterPageService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnterPageServiceImpl implements EnterPageService {
    @Autowired
    EnterPageDao enterPageDao;
    @Override
    public UserResponse login(String username, String password) {
        StudentEntity studentEntity = enterPageDao.getStudent(username);
        TeacherEntity teacherEntity = enterPageDao.getTeacher(username);
        UserResponse userResponse = new UserResponse();
        if(studentEntity != null) {
            userResponse.setPhone(username);
            if(studentEntity.getPassword().equals(password)) {
                BeanUtils.copyProperties(studentEntity, userResponse);
                userResponse.setType("student");
            }
        }

        if(teacherEntity != null) {
            userResponse.setPhone(username);
            if(teacherEntity.getPassword().equals(password)) {
                BeanUtils.copyProperties(teacherEntity, userResponse);
                userResponse.setType("teacher");
            }
        }

        return userResponse;
    }

    @Override
    public Integer regist(RegistRequest registRequest) {
        StudentEntity studentEntityExist = enterPageDao.getStudent(registRequest.getUsername());
        TeacherEntity teacherEntityExist = enterPageDao.getTeacher(registRequest.getUsername());
        if(!registRequest.getStudentNum().equals("")) {
            if(studentEntityExist != null || teacherEntityExist != null) {
                return -1;
            }
            StudentEntity studentEntity = new StudentEntity();
            BeanUtils.copyProperties(registRequest, studentEntity);
            studentEntity.setPhone(registRequest.getUsername());
            studentEntity.setStudentName(registRequest.getName());
            studentEntity.setStudentId("ktpst" + registRequest.getUsername());
            studentEntity.setPhone(registRequest.getUsername());
            enterPageDao.registStudent(studentEntity);
        } else {
            if(studentEntityExist != null || teacherEntityExist != null) {
                return -1;
            }
            TeacherEntity teacherEntity = new TeacherEntity();
            BeanUtils.copyProperties(registRequest, teacherEntity);
            teacherEntity.setTeacherId("ktpte" + registRequest.getUsername());
            teacherEntity.setPhone(registRequest.getUsername());
            teacherEntity.setTeacherName(registRequest.getName());
            enterPageDao.registTeacher(teacherEntity);
        }
        return 1;
    }


}
