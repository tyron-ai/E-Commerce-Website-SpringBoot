package com.ecommerce.ECommerce.Website.repository;

import com.ecommerce.ECommerce.Website.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    User findByEmail(String email);
}
