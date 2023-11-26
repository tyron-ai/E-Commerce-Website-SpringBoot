package com.ecommerce.ECommerce.Website.model;

import jakarta.persistence.*;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotBlank;

@Entity
@Table(name="categories")
@Component
public class Category  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "category_name")
    private @NotBlank String categoryName;
    @Column(name = "description")
    private @NotBlank String description;
    @Column(name = "image_url")
    private String imageUrl;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {

        this.imageUrl = imageUrl;
    }
}




