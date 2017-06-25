package com.mcp.myslice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mcp.myslice.model.SizeNPrice;

public interface SizeNPriceRepository extends JpaRepository<SizeNPrice, Long>{

	public List<SizeNPrice> findByProductId(Long productId);

}
