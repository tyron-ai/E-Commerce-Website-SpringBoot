package com.ecommerce.ECommerce.Website.service;

import com.ecommerce.ECommerce.Website.dto.cart.AddToCartDto;
import com.ecommerce.ECommerce.Website.dto.cart.CartDto;
import com.ecommerce.ECommerce.Website.dto.cart.CartItemDto;
import com.ecommerce.ECommerce.Website.model.Cart;
import com.ecommerce.ECommerce.Website.model.Product;
import com.ecommerce.ECommerce.Website.model.User;
import com.ecommerce.ECommerce.Website.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CartService {

    @Autowired
    ProductService productService;

    @Autowired
    CartRepository cartRepository;

    public void addToCart(AddToCartDto addToCartDto, User user) {

        //Validate if product id is valid
        Product product = productService.findById(addToCartDto.getProductId());

        //Save to cart
        Cart cart=new Cart();
        cart.setProduct(product);
        cart.setUser(user);
        cart.setQuantity(addToCartDto.getQuantity());
        cart.setCreatedDate(new Date());

        //Save the cart
        cartRepository.save(cart);

    }

    public CartDto listCart(User user)
    {
        List<Cart> cartStuff = cartRepository.findAllByUserOrderByCreatedDateDesc(user);

        List<CartItemDto> cartItems=new ArrayList<>();
        double costs=0;
        for(Cart cart:cartStuff)
        {
            CartItemDto cartItemDto=new CartItemDto(cart);
            costs+=cartItemDto.getQuantity()*cart.getProduct().getPrice();
            cartItems.add(cartItemDto);
        }

        CartDto cartDto=new CartDto();
        cartDto.setTotalCost(costs);
        cartDto.setCartItems(cartItems);

        return cartDto;

    }

}
