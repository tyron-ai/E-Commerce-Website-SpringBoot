package com.ecommerce.ECommerce.Website.dto;

import javax.validation.constraints.NotNull;

public class ProductDto {

    //for create it can be optional
    //for update we need it
    private Integer id;
    private @NotNull String product_name;
    private @NotNull String image_url;
    private @NotNull String product_description;
    private @NotNull double price;
    private @NotNull Integer categoryID;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ProductDto() {
    }
    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getProduct_description() {
        return product_description;
    }

    public void setProduct_description(String product_description) {
        this.product_description = product_description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Integer getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(Integer categoryID) {
        this.categoryID = categoryID;
    }
}
