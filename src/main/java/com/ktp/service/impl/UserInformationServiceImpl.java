package com.ktp.service.impl;

import com.ktp.dao.EnterPageDao;
import com.ktp.entity.StudentEntity;
import com.ktp.entity.TeacherEntity;
import com.ktp.request.UserRequest;
import com.ktp.response.UserResponse;
import com.ktp.service.UserInformationService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInformationServiceImpl implements UserInformationService {

    @Autowired
    EnterPageDao enterPageDao;

    @Override
    public UserResponse getUserInformation(String username) {
        StudentEntity studentEntity = enterPageDao.getStudent(username);
        TeacherEntity teacherEntity = enterPageDao.getTeacher(username);
        UserResponse userResponse = new UserResponse();
        if(studentEntity != null) {
            userResponse.setPhone(username);
            BeanUtils.copyProperties(studentEntity, userResponse);
            userResponse.setType("student");

        }

        if(teacherEntity != null) {
            userResponse.setPhone(username);
            BeanUtils.copyProperties(teacherEntity, userResponse);
            userResponse.setType("teacher");

        }

        return userResponse;
    }
}
