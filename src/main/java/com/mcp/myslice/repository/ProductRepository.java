package com.mcp.myslice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mcp.myslice.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

	public List<Product> findByActive(String active);

}
