package com.ecommerce.ECommerce.Website.service;

import com.ecommerce.ECommerce.Website.model.Category;
import com.ecommerce.ECommerce.Website.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    public void createCategory(Category category){
        categoryRepository.save(category);

    }

    public List<Category> listCategories()
    {
       return categoryRepository.findAll();
    }
}
