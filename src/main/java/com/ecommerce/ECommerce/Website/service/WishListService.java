package com.ecommerce.ECommerce.Website.service;

import com.ecommerce.ECommerce.Website.dto.ProductDto;
import com.ecommerce.ECommerce.Website.model.Product;
import com.ecommerce.ECommerce.Website.model.User;
import com.ecommerce.ECommerce.Website.model.WishList;
import com.ecommerce.ECommerce.Website.repository.WishListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Date;

@Service
public class WishListService {

    @Autowired
    WishListRepository wishListRepository;
    @Autowired
    ProductService productService;


    public void createWishList(WishList wishList) {

        wishListRepository.save(wishList);
    }

    public WishList findByUserAndProduct(User user, Product product) {
        return wishListRepository.findByUserAndProduct(user,product);
    }

    public List<ProductDto> getFromWishList(User user) {
        List<WishList> wishListItems = wishListRepository.findAllByUserOrderByCreatedDateDesc(user);

        //Find productDtos and send them back
        List<ProductDto> products=new ArrayList<>();

        for(WishList wishList:wishListItems)
        {
            products.add(productService.getProductDto(wishList.getProduct()));
        }

        return products;
    }
}
