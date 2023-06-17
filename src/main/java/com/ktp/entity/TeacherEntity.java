package com.ktp.entity;

import lombok.Data;
import java.io.Serializable;

@Data
public class TeacherEntity implements Serializable {

    private String teacherId;

    private String teacherName;

    private String password;

    private String courseUnFiled;

    private String courseFiled;

    private String school;

    private String phone;
}
