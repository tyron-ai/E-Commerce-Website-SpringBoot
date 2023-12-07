package com.ecommerce.ECommerce.Website.controller;

import com.ecommerce.ECommerce.Website.common.APIResponse;
import com.ecommerce.ECommerce.Website.dto.ProductDto;
import com.ecommerce.ECommerce.Website.model.Product;
import com.ecommerce.ECommerce.Website.model.User;
import com.ecommerce.ECommerce.Website.model.WishList;
import com.ecommerce.ECommerce.Website.service.AuthenticationService;
import com.ecommerce.ECommerce.Website.service.WishListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/wishList")
public class WishListController {

    @Autowired
    WishListService wishListService;

    @Autowired
    AuthenticationService authenticationService;

    //2 API's  1 to save product in wishList and get all products in Wishlist
    @PostMapping("/add/{token}")
    public ResponseEntity<APIResponse> addToWishlist(@RequestBody Product product
            , @PathVariable String token)
    {
        //Authenticate the token
        authenticationService.authenticate(token);

        //Find the user
        User user=authenticationService.getUser(token);

        //Save the item in wishList if it does not already exist
        WishList existingWishListItem = wishListService.findByUserAndProduct(user, product);

        if (existingWishListItem == null) {
            WishList wishList = new WishList(user, product);
            wishListService.createWishList(wishList);

            APIResponse apiResponse = new APIResponse(true, "Added to wish list.");
            return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);
        } else {
            APIResponse apiResponse = new APIResponse(false, "Product already exists in wish list.");
            return new ResponseEntity<>(apiResponse, HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("/get/{token}")
    public ResponseEntity<List<ProductDto>> getWishlist(@PathVariable String token)
    {
        //Authenticate the token
        authenticationService.authenticate(token);

        //Find the user
        User user=authenticationService.getUser(token);

        List<ProductDto> productDtos = wishListService.getFromWishList(user);

        return new ResponseEntity<>(productDtos,HttpStatus.OK);

    }
}
