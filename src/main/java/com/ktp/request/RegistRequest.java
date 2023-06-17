package com.ktp.request;

import lombok.Data;

@Data
public class RegistRequest {
    private String username;

    private String name;

    private String password;

    private String school;

    private String studentNum;
}
