package com.ecommerce.ECommerce.Website.model;

import jakarta.persistence.*;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotBlank;

@Entity
@Table(name="category")
public class Category  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "category_name")
    private @NotBlank String category_name;
    @Column(name = "description")
    private @NotBlank String description;
    @Column(name = "imageUrl")
    private String imageUrl;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
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
