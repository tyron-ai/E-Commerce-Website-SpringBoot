package com.ecommerce.ECommerce.Website.service;

import com.ecommerce.ECommerce.Website.dto.ProductDto;
import com.ecommerce.ECommerce.Website.model.Category;
import com.ecommerce.ECommerce.Website.model.Product;
import com.ecommerce.ECommerce.Website.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public void createProduct(ProductDto productDto, Category category) {
        Product product=new Product();
        product.setProduct_name(productDto.getProduct_name());
        product.setDescription(productDto.getProduct_description());
        product.setImageUrl(productDto.getImage_url());
        product.setPrice(productDto.getPrice());
        product.setCategory(category);

        productRepository.save(product);
    }

    //Need to change Product into productDto
    public ProductDto getProductDto(Product product)
    {
        ProductDto productDto=new ProductDto();
        productDto.setProduct_name(product.getProduct_name());
        productDto.setProduct_description(product.getDescription());
        productDto.setImage_url(product.getImageUrl());
        productDto.setPrice(product.getPrice());
        productDto.setId(product.getId());
        productDto.setCategoryID(product.getCategory().getId());

        return productDto;
    }
    public List<ProductDto> getAllProducts() {
        List<Product> allProducts = productRepository.findAll();

        //List of productDtos
        List<ProductDto> productDtos=new ArrayList<>();
        //Need to change Product into productDto
        for (Product product:allProducts) {
            productDtos.add(getProductDto(product));

        }
        return  productDtos;
    }

    public void updateProduct(ProductDto productDto, Integer productId) throws Exception {
        Optional<Product> byId = productRepository.findById(productId);

        //Throw exception if product does not exist
        if(!byId.isPresent())
        {
            throw new Exception("Product does not exist");
        }
        Product product=byId.get();
        product.setProduct_name(productDto.getProduct_name());
        product.setDescription(productDto.getProduct_description());
        product.setImageUrl(productDto.getImage_url());
        product.setPrice(productDto.getPrice());

        productRepository.save(product);


    }

    public void removeProduct(Integer productId) {

        Optional<Product> byId = productRepository.findById(productId);

        productRepository.delete(byId.get());
    }
}
