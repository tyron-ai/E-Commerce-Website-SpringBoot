package com.ecommerce.ECommerce.Website.controller;

import com.ecommerce.ECommerce.Website.dto.ResponseDto;
import com.ecommerce.ECommerce.Website.dto.user.SignInDto;
import com.ecommerce.ECommerce.Website.dto.user.SignInResponseDto;
import com.ecommerce.ECommerce.Website.dto.user.SignUpDto;
import com.ecommerce.ECommerce.Website.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    //We will create 2 API's- Sign Up and Sign In

    //Sign Up
    @PostMapping("/signUp")
    public ResponseDto signUp(@RequestBody SignUpDto signUpDto)
    {
        return userService.signUp(signUpDto);
    }

    //Sign In
    @PostMapping("/signIn")
    public SignInResponseDto signIn(@RequestBody SignInDto signInDto)
    {
        return userService.signIn(signInDto);
    }

}
