package com.mcp.myslice.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mcp.myslice.model.Address;

@Transactional
public interface AddressRepository extends JpaRepository<Address, Long>{

}
