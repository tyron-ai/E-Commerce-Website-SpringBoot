package com.ecommerce.ECommerce.Website.repository;

import com.ecommerce.ECommerce.Website.model.AuthenticationToken;
import com.ecommerce.ECommerce.Website.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TokenRepository extends JpaRepository<AuthenticationToken, Integer> {

    AuthenticationToken findByUser(User user);

    AuthenticationToken findByToken(String token);


}
