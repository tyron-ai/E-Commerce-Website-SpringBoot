package com.ecommerce.ECommerce.Website.controller;

import com.ecommerce.ECommerce.Website.model.Category;
import com.ecommerce.ECommerce.Website.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping("/create")
    public String createCategory(@RequestBody Category category)
    {
        categoryService.createCategory(category);
        return "Successful";
    }

    @GetMapping("/listCategories")
    public List<Category> listCategories()
    {
        return categoryService.listCategories();
    }

}
