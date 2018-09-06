package com.isscollege.gdce.service;

import com.isscollege.gdce.domain.User;

public interface ILoginService
{
	User login(User user);
	boolean logout(User user);
	
	boolean ajaxValidateLoginname(String name);
	boolean ajaxValidateLoginpassword(String name,String password);
	public boolean  ajaxValidateLoginState(String name);
}
