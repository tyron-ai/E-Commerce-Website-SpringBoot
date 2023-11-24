package com.ecommerce.ECommerce.Website.service;

import com.ecommerce.ECommerce.Website.model.Category;
import com.ecommerce.ECommerce.Website.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

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

    public void editCategory(Integer id, Category updateCategory) {

        Category category=categoryRepository.getReferenceById(id);

        if (category == null) {
            throw new NoSuchElementException("Category not found with ID: " + id);
        }

        category.setCategoryName(updateCategory.getCategoryName());
        category.setDescription(updateCategory.getDescription());
        category.setImageUrl(updateCategory.getImageUrl());
        categoryRepository.save(category);

    }

    public Boolean findById(Integer id) {
        return categoryRepository.findById(id).isPresent();
    }
}
