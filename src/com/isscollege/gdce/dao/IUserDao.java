package com.isscollege.gdce.dao;

import java.sql.SQLException;
import java.util.List;

import com.isscollege.gdce.domain.User;
import com.isscollege.gdce.domain.Company;
public interface IUserDao
{
	User queryUserByName(String name) throws SQLException;
	User queryUserByCompanyId(String companyId) throws SQLException;
	
	boolean insertUser(User user) throws SQLException;
	boolean insertCompany(Company company) throws SQLException;
	
	public boolean ajaxValidateLoginname(String name) throws SQLException;
	public boolean ajaxValidateCompanyId(String companyId) throws SQLException;
	public boolean ajaxValidateLoginpassword(String name,String pasword) throws SQLException;
	public boolean ajaxValidateLoginState(String name) throws SQLException;
	
	public boolean updateUser_loginstate_ByName(User user) throws SQLException;
	
	List<User> queryManager() throws SQLException;

	boolean addManager(User manager) throws SQLException;

	boolean deleteManager(String id) throws SQLException;

	int queryLevelById(String id) throws SQLException;
	//公司信息相关dao
	public boolean updateCompany(Company company) throws SQLException;
	public Company queryCompanyByCompanyID(String Companyid) throws SQLException;
}
