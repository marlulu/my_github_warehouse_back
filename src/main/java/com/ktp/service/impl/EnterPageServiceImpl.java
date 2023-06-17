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
        StudentEntity studentEntity = enterPageDao.loginStudent(username);
        TeacherEntity teacherEntity = enterPageDao.loginTeacher(username);
        UserResponse userResponse = new UserResponse();
        if(studentEntity != null) {
            userResponse.setPhone(username);
            if(studentEntity.getPassword().equals(password)) {
                BeanUtils.copyProperties(studentEntity, userResponse);
            }
        }

        if(teacherEntity != null) {
            userResponse.setPhone(username);
            if(teacherEntity.getPassword().equals(password)) {
                BeanUtils.copyProperties(teacherEntity, userResponse);
            }
        }

        return userResponse;
    }

    @Override
    public Integer regist(RegistRequest registRequest) {
        if(!registRequest.getStudentNum().equals("")) {
            StudentEntity studentEntityExist = enterPageDao.loginStudent(registRequest.getUsername());
            if(studentEntityExist != null) {
                return -1;
            }
            StudentEntity studentEntity = new StudentEntity();
            BeanUtils.copyProperties(registRequest, studentEntity);
            studentEntity.setPhone(registRequest.getUsername());
            studentEntity.setStudentName(registRequest.getName());
            studentEntity.setStudentId("ktp" + registRequest.getUsername());
            studentEntity.setPhone(registRequest.getUsername());
            enterPageDao.registStudent(studentEntity);
        } else {
            TeacherEntity teacherEntityExist = enterPageDao.loginTeacher(registRequest.getUsername());
            if(teacherEntityExist != null) {
                return -1;
            }
            TeacherEntity teacherEntity = new TeacherEntity();
            BeanUtils.copyProperties(registRequest, teacherEntity);
            teacherEntity.setTeacherId("ktp" + registRequest.getUsername());
            teacherEntity.setPhone(registRequest.getUsername());
            teacherEntity.setTeacherName(registRequest.getName());
            enterPageDao.registTeacher(teacherEntity);
        }
        return 1;
    }


}
