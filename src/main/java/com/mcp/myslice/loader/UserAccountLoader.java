package com.mcp.myslice.loader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.mcp.myslice.model.UserAccount;
import com.mcp.myslice.repository.UserAccountRepository;
import com.mcp.myslice.utils.Encryptor;

/**
 * 
 * Load the initial user account which is the admin.
 *
 */

@Component
public class UserAccountLoader  implements ApplicationListener<ContextRefreshedEvent>{

	private Encryptor encryptor = new Encryptor();
	private UserAccountRepository userAccountRepository;

	@Autowired
	public void setUserAccountRepository(UserAccountRepository userAccountRepository) {
		this.userAccountRepository = userAccountRepository;
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent arg0) {
		// TODO Auto-generated method stub

		if(userAccountRepository.findAll().isEmpty()){
			userAccountRepository.save(new UserAccount("admin@gmail.com", encryptor.getSecurePassword("qwerty"), "System", "Admin"));
		}
 
	}



}
