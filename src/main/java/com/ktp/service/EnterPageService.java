package com.ktp.service;

import com.ktp.request.RegistRequest;
import com.ktp.response.UserResponse;

public interface EnterPageService {
    UserResponse login(String username, String password);

    Integer regist(RegistRequest registRequest);

}
