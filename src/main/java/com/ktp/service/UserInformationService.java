package com.ktp.service;

import com.ktp.request.UserRequest;
import com.ktp.response.UserResponse;

public interface UserInformationService {

    UserResponse getUserInformation(String username);

}
