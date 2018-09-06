package com.isscollege.gdce.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.isscollege.gdce.common.dao.impl.BasicDao;
import com.isscollege.gdce.dao.ILoginDao;
import com.isscollege.gdce.domain.User;

public class LoginDaoImpl extends BasicDao implements ILoginDao
{
	private static String INSERT_USER = "SELECT id,NAME,PASSWORD,isRemember,loginState FROM system_users WHERE NAME='%s'";
	
	@Override
	public User queryUserByName(String name) throws SQLException
	{
		String s = String.format(INSERT_USER, name);
		List<User> userList = this.query(String.format(INSERT_USER, name), User.class);
		return userList.size() > 0 ? userList.get(0) : null;
	}
}
