package com.ecommerce.ECommerce.Website.repository;

import com.ecommerce.ECommerce.Website.model.AuthenticationToken;
import io.swagger.models.auth.In;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TokenRepository extends JpaRepository<AuthenticationToken, In> {
}
