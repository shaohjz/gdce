package com.isscollege.gdce.model.impl;

import com.isscollege.gdce.domain.User;
import com.isscollege.gdce.model.ILoginModel;
import com.isscollege.gdce.service.ILoginService;
import com.isscollege.gdce.service.impl.LoginServiceImpl;

public class LoginModelImpl implements ILoginModel
{
	private ILoginService service = null;
	
	public LoginModelImpl()
	{
		service = new LoginServiceImpl();
	}

	@Override
	public User login(User user)
	{
		return service.login(user);
	}
	
	@Override
	public boolean logout(User user) {
		return service.logout(user);
	}
	
	@Override
	public boolean  ajaxValidateLoginname(String name)
	{
		return service.ajaxValidateLoginname(name);
	}
	
	@Override
	public boolean ajaxValidateLoginpassword(String name,String password)
	{
		return service.ajaxValidateLoginpassword(name,password);
	}
	
	@Override
	public boolean  ajaxValidateLoginState(String name)
	{
		return service.ajaxValidateLoginState(name);
	}
}
