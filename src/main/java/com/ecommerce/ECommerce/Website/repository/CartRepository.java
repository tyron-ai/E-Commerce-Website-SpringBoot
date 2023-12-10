package com.ecommerce.ECommerce.Website.repository;

import com.ecommerce.ECommerce.Website.model.Cart;
import com.ecommerce.ECommerce.Website.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartRepository extends JpaRepository<Cart,Integer> {
    List<Cart> findAllByUserOrderByCreatedDateDesc(User user);
}
