package com.mcp.myslice.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mcp.myslice.model.UserAccount;

@Transactional
public interface UserAccountRepository extends JpaRepository<UserAccount, Long>{
	List<UserAccount> findByLastName(String lastName);
	UserAccount findByEmailAddress(String emailAddress);
}
