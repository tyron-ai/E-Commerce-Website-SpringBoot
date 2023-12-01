package com.ecommerce.ECommerce.Website.exceptions;

public class CustomException extends IllegalArgumentException{

    public CustomException(String message)
    {
        super(message);
    }
}
