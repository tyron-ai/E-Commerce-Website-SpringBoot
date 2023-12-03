package com.ecommerce.ECommerce.Website.exceptions;

public class AuthenticationFailException  extends IllegalArgumentException{

    public AuthenticationFailException(String message)
    {
        super(message);
    }
}
