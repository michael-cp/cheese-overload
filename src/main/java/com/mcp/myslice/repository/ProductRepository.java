package com.mcp.myslice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mcp.myslice.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{


}
