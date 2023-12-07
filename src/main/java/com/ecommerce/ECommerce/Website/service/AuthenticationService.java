package com.ecommerce.ECommerce.Website.service;

import com.ecommerce.ECommerce.Website.exceptions.AuthenticationFailException;
import com.ecommerce.ECommerce.Website.model.AuthenticationToken;
import com.ecommerce.ECommerce.Website.model.User;
import com.ecommerce.ECommerce.Website.repository.TokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class AuthenticationService {

    @Autowired
    TokenRepository tokenRepository;


    public void saveToken(AuthenticationToken userToken) {
    tokenRepository.save(userToken);
    }

    public AuthenticationToken getToken(User user) {
        return tokenRepository.findByUser(user);
    }

    //Get User from Token
    public User getUser(String token)
    {
       final AuthenticationToken authenticationToken=tokenRepository.findByToken(token);

       if(Objects.isNull(authenticationToken)){
           return null;
       }

       return authenticationToken.getUser();

    }
    public void authenticate(String token) throws AuthenticationFailException {
        //Null check
        if(Objects.isNull (token))
        {
            //throw an exception
            throw new AuthenticationFailException("Token does not exist.");
        }

        if(Objects.isNull(getUser(token)))
        {
            throw new AuthenticationFailException("Token not valid.");

        }




    }
}
