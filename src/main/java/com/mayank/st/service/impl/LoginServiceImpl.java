package com.mayank.st.service.impl;

import org.springframework.stereotype.Service;

import com.mayank.st.entity.LoginData;
import com.mayank.st.respository.LoginRespository;
import com.mayank.st.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService{
	
	private LoginRespository loginRespository;
	private LoginData loginTryData;
	public LoginServiceImpl(LoginRespository loginRespository) {
		super();
		this.loginRespository = loginRespository;
	}

	@Override
	public boolean tryLogin(LoginData login) {
		try {
			loginTryData = loginRespository.findById(login.getUsername()).get();
		} catch (Exception e) {
			return false;
		}
		return (loginTryData.getPassword().equals(login.getPassword()));
	}

}
