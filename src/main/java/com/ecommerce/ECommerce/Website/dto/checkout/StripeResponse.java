package com.ecommerce.ECommerce.Website.dto.checkout;

public class StripeResponse {

    private String sesionId;

    public String getSesionId() {
        return sesionId;
    }

    public void setSesionId(String sesionId) {
        this.sesionId = sesionId;
    }

    public StripeResponse(String sesionId) {
        this.sesionId = sesionId;
    }
}
