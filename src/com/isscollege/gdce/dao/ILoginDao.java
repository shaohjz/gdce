package com.isscollege.gdce.dao;

import java.sql.SQLException;

import com.isscollege.gdce.domain.User;

public interface ILoginDao
{
	User queryUserByName(String name) throws SQLException;
}
