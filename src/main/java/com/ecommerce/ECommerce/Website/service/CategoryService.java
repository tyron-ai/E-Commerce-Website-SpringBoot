package com.ecommerce.ECommerce.Website.service;

import com.ecommerce.ECommerce.Website.model.Category;
import com.ecommerce.ECommerce.Website.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    CategoryRepository categoryRepository;
    @Autowired
    public void createCategory(Category category){
        categoryRepository.save(category);

    }
}
