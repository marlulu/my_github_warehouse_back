package com.ktp.controller;

import com.ktp.common.Result;
import com.ktp.request.RegistRequest;
import com.ktp.request.UserRequest;
import com.ktp.response.UserResponse;
import com.ktp.service.EnterPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(value = "api/enter")
public class EnterPageController {

    @Autowired
    private EnterPageService enterPageService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public Result<UserResponse> login(@RequestBody UserRequest userRequest) {
        try{
            UserResponse userResponse = enterPageService.login(userRequest.getUsername(), userRequest.getPassword());
            if(userResponse.getPhone() == null) {
                return Result.error("账号未注册");
            } else if(userResponse.getPassword() == null){
                return Result.error("密码输入错误");
            }
            return Result.success("登陆成功", userResponse);
        } catch (Exception e) {
            return Result.error(e.getMessage());
        }

    }

    @RequestMapping(value = "/regist", method = RequestMethod.POST)
    @ResponseBody
    public Result<Integer> regist(@RequestBody RegistRequest registRequest) {
        try{
            Integer num = enterPageService.regist(registRequest);
            if(num > 0) {
                return Result.success("注册成功", num);
            } else {
                return Result.error("该账号已存在，无法注册");
            }
        } catch (Exception e) {
            return Result.error(e.getMessage());
        }

    }
}
