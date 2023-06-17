package com.ktp.entity;

import lombok.Data;
import java.io.Serializable;

@Data
public class StudentEntity implements Serializable {

    private String studentId;

    private String studentName;

    private String studentNum;

    private String password;

    private String courseUnFiled;

    private String courseFiled;

    private String homeworkId;

    private String school;

    private String phone;
}
