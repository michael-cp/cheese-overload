package com.mcp.myslice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mcp.myslice.model.CustomerAddress;

public interface CustomerAddressRepository extends JpaRepository<CustomerAddress, Long>{


}
