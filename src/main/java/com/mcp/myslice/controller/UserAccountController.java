package com.mcp.myslice.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mcp.myslice.model.UserAccount;
import com.mcp.myslice.repository.UserAccountRepository;
import com.mcp.myslice.utils.ApplicationConstants;
import com.mcp.myslice.utils.Encryptor;

@RestController
@RequestMapping("api/v1/")
public class UserAccountController {

	@Autowired
	private UserAccountRepository userAccountRepository;
	
	private Encryptor encryptor;

	@RequestMapping(value = "useraccounts" , method = RequestMethod.GET)
	public List<UserAccount> list(){
		return userAccountRepository.findAll();
	}

	@RequestMapping(value = "useraccounts" , method = RequestMethod.POST)
	public UserAccount create(@RequestBody UserAccount userAccount){
		userAccount.setPassword(encryptor.getSecurePassword(userAccount.getPassword()));
		return userAccountRepository.saveAndFlush(userAccount);
	}

	@RequestMapping(value = "useraccounts/{id}" , method = RequestMethod.GET)
	public UserAccount get(@PathVariable Long id){
		return userAccountRepository.findOne(id);
	}

	@RequestMapping(value = "useraccounts/{id}" , method = RequestMethod.PUT)
	public UserAccount update(@PathVariable Long id, @RequestBody UserAccount userAccount){
		UserAccount existingUserAccount = userAccountRepository.findOne(id);
		
		userAccount.setPassword(encryptor.getSecurePassword(userAccount.getPassword()));
		BeanUtils.copyProperties(userAccount, existingUserAccount);
		return userAccountRepository.saveAndFlush(existingUserAccount);
	}

	@RequestMapping(value = "useraccounts/{id}" , method = RequestMethod.DELETE)
	public UserAccount delete(@PathVariable Long id, @RequestBody UserAccount userAccount){
		UserAccount existingUserAccount = userAccountRepository.findOne(id);

		/**
			Disabled the actual deletion of data.
		 **/
		//userAccountRepository.delete(existingUserAccount);


		/*
			Instead of deleting the actual data, flag the Active attribute to No/"N"..
		 */
		existingUserAccount.setActive(ApplicationConstants.ACTIVE_NO);
		BeanUtils.copyProperties(userAccount, existingUserAccount);
		userAccountRepository.saveAndFlush(existingUserAccount);

		return existingUserAccount;
	}	
}
