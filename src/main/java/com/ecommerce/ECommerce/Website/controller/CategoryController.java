package com.ecommerce.ECommerce.Website.controller;

import com.ecommerce.ECommerce.Website.common.APIResponse;
import com.ecommerce.ECommerce.Website.model.Category;
import com.ecommerce.ECommerce.Website.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<APIResponse> createCategory(@RequestBody Category category)
    {
        categoryService.createCategory(category);
        return new ResponseEntity<>(new APIResponse(true,"Successfully created new category"), HttpStatus.CREATED);
    }

    @GetMapping("/listCategories")
    public List<Category> listCategories()
    {
        return categoryService.listCategories();
    }

    @PostMapping("/updateCategory/{categoryID}")
    public ResponseEntity<APIResponse> updateCategory(@PathVariable("categoryID") Integer id,@RequestBody Category category)
    {
        if(!categoryService.findById(id))
        {
            return new ResponseEntity<>(new APIResponse(false,"Failed to update category"),HttpStatus.NOT_FOUND);
        }
        categoryService.editCategory(id, category);
        return new ResponseEntity<>(new APIResponse(true,"Successfully updated category"),HttpStatus.OK);
    }

}
