package com.ecommerce.ECommerce.Website.service;

import com.ecommerce.ECommerce.Website.dto.ResponseDto;

import com.ecommerce.ECommerce.Website.dto.user.SignInDto;
import com.ecommerce.ECommerce.Website.dto.user.SignInResponseDto;
import com.ecommerce.ECommerce.Website.dto.user.SignUpDto;
import com.ecommerce.ECommerce.Website.exceptions.AuthenticationFailException;
import com.ecommerce.ECommerce.Website.exceptions.CustomException;
import com.ecommerce.ECommerce.Website.model.AuthenticationToken;
import com.ecommerce.ECommerce.Website.model.User;
import com.ecommerce.ECommerce.Website.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    AuthenticationService authenticationService;

    @Transactional //Suppose user generated but token not saved then newly created user is reverted since we want it to happen together
    //Basically when a new user is created a token is also created
    public ResponseDto signUp(SignUpDto signUpDto) {
        //check if user does not exist
        if (Objects.nonNull(userRepository.findByEmail(signUpDto.getEmail())))
        {
            //We arleady have a user
            throw new CustomException("User already exists");
        }

        //Hash the password
        String encryptedPassword= signUpDto.getPassword();

        try{
            encryptedPassword=hashPassword(signUpDto.getPassword());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        User user=new User(signUpDto.getFirst_name()
                ,signUpDto.getLast_name()
                ,signUpDto.getEmail()
                ,encryptedPassword);

        //Saving user
        userRepository.save(user);

        //Creating token
        final AuthenticationToken userToken = new AuthenticationToken(user);

        //Saving token
        authenticationService.saveToken(userToken);


        return new ResponseDto("success","Successfully signed up and created user: "
                +signUpDto.getFirst_name()+" "+signUpDto.getLast_name());

    }

    private String hashPassword(String password) {
        try{
            MessageDigest md5 = MessageDigest.getInstance("MD5");

            md5.update(password.getBytes());
            byte[] digest = md5.digest();

            return DatatypeConverter.
                    printHexBinary(digest).toUpperCase();
        }
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error hashing password", e);
        }
    }

    public SignInResponseDto signIn(SignInDto signInDto) {
        //Find user by email
        User user=userRepository.findByEmail(signInDto.getEmail());

        if(Objects.isNull(user))
        {
            throw  new AuthenticationFailException("User " +signInDto.getEmail() +" does not exist.");
        }

        //Hash password
        //Compare passwords
        try
        {
            if (!user.getPassword().equals(hashPassword(signInDto.getPassword())))
            {
                throw new AuthenticationFailException("Password is incorrect.");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        //If passwords match, retrieve the token

        AuthenticationToken token=authenticationService.getToken(user);

        if(Objects.isNull(token))
        {
            throw new CustomException("Token does not exist.");
        }

        //Return response
        return new SignInResponseDto("success",token.getToken());

    }
}
