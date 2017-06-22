package com.mcp.myslice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mcp.myslice.model.Customer;


public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
