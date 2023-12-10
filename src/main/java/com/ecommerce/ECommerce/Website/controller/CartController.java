package com.ecommerce.ECommerce.Website.controller;

import com.ecommerce.ECommerce.Website.common.APIResponse;
import com.ecommerce.ECommerce.Website.dto.cart.AddToCartDto;
import com.ecommerce.ECommerce.Website.dto.cart.CartDto;
import com.ecommerce.ECommerce.Website.model.User;
import com.ecommerce.ECommerce.Website.service.AuthenticationService;
import com.ecommerce.ECommerce.Website.service.CartService;
import com.ecommerce.ECommerce.Website.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    CartService cartService;

    @Autowired
    AuthenticationService authenticationService;

    @Autowired
    ProductService productService;

    //Add to cart
    @PostMapping("/add/{token}")
    public ResponseEntity<APIResponse> addToCart(@RequestBody AddToCartDto addToCartDto,
                                                 @PathVariable String token)
    {
        //Authenticate the token
        authenticationService.authenticate(token);

        //Find the user
        User user=authenticationService.getUser(token);

        cartService.addToCart(addToCartDto,user);

        return new ResponseEntity<>(new APIResponse(true,"Added to cart"), HttpStatus.CREATED);

    }

    //Get cart for user
    @GetMapping("/getCart/{token}")
    public ResponseEntity<CartDto> getCart(@PathVariable String token)
    {
        //Authenticate the token
        authenticationService.authenticate(token);

        //Find the user
        User user=authenticationService.getUser(token);

        //Get cart items
        CartDto cartDto=cartService.listCart(user);

        return new ResponseEntity<>(cartDto,HttpStatus.OK);

    }

    //Remove Item From Cart
    @DeleteMapping("/delete/{token}/{cartItemId}")
    public ResponseEntity<APIResponse> delFromCart(@PathVariable String token,@PathVariable Integer cartItemId)
    {
        //Authenticate the token
        authenticationService.authenticate(token);

        //Find the user
        User user=authenticationService.getUser(token);

        cartService.deleteCartItem(cartItemId,user);

        return new ResponseEntity<>(new APIResponse(true, "Item has been successfully removed"), HttpStatus.OK);

    }


}
