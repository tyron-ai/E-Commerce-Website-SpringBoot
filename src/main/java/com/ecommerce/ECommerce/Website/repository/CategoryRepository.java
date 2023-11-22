package com.ecommerce.ECommerce.Website.repository;

import com.ecommerce.ECommerce.Website.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Integer> {
}
