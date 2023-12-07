package com.ecommerce.ECommerce.Website.repository;

import com.ecommerce.ECommerce.Website.model.Product;
import com.ecommerce.ECommerce.Website.model.User;
import com.ecommerce.ECommerce.Website.model.WishList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;
@Repository
public interface WishListRepository extends JpaRepository<WishList,Integer> {
    WishList findByUserAndProduct(User user, Product product);

    List<WishList> findAllByUserOrderByCreatedDateDesc(User user);

}
