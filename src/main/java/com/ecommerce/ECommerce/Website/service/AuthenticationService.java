package com.ecommerce.ECommerce.Website.service;

import com.ecommerce.ECommerce.Website.model.AuthenticationToken;
import com.ecommerce.ECommerce.Website.model.User;
import com.ecommerce.ECommerce.Website.repository.TokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
