package com.ecommerce.ECommerce.Website.service;

import com.ecommerce.ECommerce.Website.dto.ResponseDto;
import com.ecommerce.ECommerce.Website.dto.user.SignUpDto;
import com.ecommerce.ECommerce.Website.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;
    public ResponseDto signUp(SignUpDto signUpDto) {
        //check if user does not exist
        if (Objects.nonNull(userRepository.findByEmail(signUpDto.getEmail())))
        {
            ResponseDto responseDto=new ResponseDto("False","User already exists");
        }


        //Save user
        //Hash the password

        //Create token

        ResponseDto responseDto=new ResponseDto("success","Dummy response");
        return responseDto;
    }
}
