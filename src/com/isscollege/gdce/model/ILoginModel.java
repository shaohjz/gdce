package com.isscollege.gdce.model;

import com.isscollege.gdce.domain.User;

public interface ILoginModel
{
	public User login(User user);
	boolean logout(User user);
	
	boolean ajaxValidateLoginname(String name);
	boolean ajaxValidateLoginpassword(String name,String password);
	boolean ajaxValidateLoginState(String name);
}
