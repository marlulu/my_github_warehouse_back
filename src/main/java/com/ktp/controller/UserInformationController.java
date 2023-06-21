package com.ktp.controller;

import com.ktp.common.Result;
import com.ktp.request.UserRequest;
import com.ktp.response.UserResponse;
import com.ktp.service.UserInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(value = "api/user")
public class UserInformationController {

    @Autowired
    UserInformationService userInformationService;

    @RequestMapping(value = "/getUserInformation", method = RequestMethod.GET)
    @ResponseBody
    public Result<UserResponse> getUserInformation(@RequestParam(value = "username") String username) {
        try{
            UserResponse userResponse = userInformationService.getUserInformation(username);
            return Result.success("获的用户信息", userResponse);
        } catch (Exception e) {
            return Result.error(e.getMessage());
        }

    }
}
