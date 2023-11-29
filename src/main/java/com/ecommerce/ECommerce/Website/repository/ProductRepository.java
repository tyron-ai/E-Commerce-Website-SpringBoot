package com.ecommerce.ECommerce.Website.repository;

import com.ecommerce.ECommerce.Website.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Integer> {
}
