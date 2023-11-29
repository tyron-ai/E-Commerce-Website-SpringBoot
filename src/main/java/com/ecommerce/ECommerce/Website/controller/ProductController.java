package com.ecommerce.ECommerce.Website.controller;

import com.ecommerce.ECommerce.Website.common.APIResponse;
import com.ecommerce.ECommerce.Website.dto.ProductDto;
import com.ecommerce.ECommerce.Website.model.Category;
import com.ecommerce.ECommerce.Website.model.Product;
import com.ecommerce.ECommerce.Website.repository.CategoryRepository;
import com.ecommerce.ECommerce.Website.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;
    @Autowired
    CategoryRepository categoryRepository;

    @GetMapping("/getProducts")
    public ResponseEntity<List<ProductDto>> getProducts()
    {
        List<ProductDto> allProducts = productService.getAllProducts();

        return new ResponseEntity<>(allProducts,HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<APIResponse> createProduct(@RequestBody ProductDto productDto)
    {
        //Check if category ID is not null
//        if (productDto.getCategoryID() == null) {
//            return new ResponseEntity<>(new APIResponse(false, "Category does not exist"), HttpStatus.BAD_REQUEST);
//        }
        //First find if category exists
        Optional<Category> categoryId = categoryRepository.findById(productDto.getCategoryID());
        if(categoryId.isEmpty()){
            return new ResponseEntity<>(new APIResponse(false,"Category does not exist"),HttpStatus.BAD_REQUEST);
        }
        productService.createProduct(productDto,categoryId.get());
        return new ResponseEntity<>(new APIResponse(true,"Successfully added new product"), HttpStatus.CREATED);

    }

    //Edit product
    @PostMapping("/update/{productId}")
    public ResponseEntity<APIResponse> updateProduct(@PathVariable("productId") Integer productId,@RequestBody ProductDto productDto) throws Exception {
        //Check if category ID is not null
//        if (productDto.getCategoryID() == null) {
//            return new ResponseEntity<>(new APIResponse(false, "Category does not exist"), HttpStatus.BAD_REQUEST);
//        }
        //First find if category exists
        Optional<Category> categoryId = categoryRepository.findById(productDto.getCategoryID());
        if(categoryId.isEmpty()){
            return new ResponseEntity<>(new APIResponse(false,"Category does not exist"),HttpStatus.BAD_REQUEST);
        }
        productService.updateProduct(productDto,productId);
        return new ResponseEntity<>(new APIResponse(true,"Successfully updated product"), HttpStatus.OK);

    }

    @PostMapping("/remove/{productId}")
    public ResponseEntity<APIResponse> removeProduct(@PathVariable("productId") Integer productId){
        productService.removeProduct(productId);
        return new ResponseEntity<>(new APIResponse(true,"Successfully removed product"), HttpStatus.OK);

    }





}
