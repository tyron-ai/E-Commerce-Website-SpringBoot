package com.ecommerce.ECommerce.Website.common;

import java.time.LocalDateTime;

public class APIResponse {
    
    private final boolean success;
    private final String message;


    public APIResponse(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getTimeStamp(){
        return LocalDateTime.now();
    }

}
