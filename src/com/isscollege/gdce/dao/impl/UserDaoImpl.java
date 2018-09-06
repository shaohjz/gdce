package com.isscollege.gdce.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.isscollege.gdce.common.dao.impl.BasicDao;
import com.isscollege.gdce.dao.IUserDao;
import com.isscollege.gdce.domain.Company;
import com.isscollege.gdce.domain.User;

public class UserDaoImpl extends BasicDao implements IUserDao
{
	private static final String QUERY_USER = "SELECT id,NAME,PASSWORD,LEVEL,permission,companyId,isRemember,loginState FROM system_users WHERE NAME='%s'";
	private static final String QUERY_COMP = "SELECT id,NAME,PASSWORD,LEVEL,permission,companyId,isRemember,loginState FROM system_users WHERE companyId='%s'";
	private static final String INSERT_USER = "INSERT INTO system_users(NAME,PASSWORD,permission,companyId,LEVEL,isRemember,loginState) "
			+ "VALUES(?, ?,?,?,'2', FALSE, FALSE);";
	private static final String UPDATA_USER_STATE = "update system_users set loginState=? where name=? ";

	private static final String QUERY_MANAGER = "select * from system_users where level = 1;";
	private static final String INSERT_MANAGER = "INSERT INTO system_users(NAME, PASSWORD,level,permission,companyId,isRemember,loginState) VALUES(?, ?,1,?, '',FALSE, FALSE)";
	private static final String DELETE_MANAGER = "delete from system_users where id = ?";
	private static final String QUERY_LEVEL_ById = "select level from system_users where id = %s";
	private static final String INSERT_COMPANY = "INSERT INTO tbl_company_info(companyId,companyName,legalPerson,phoneNumber,bankAccount,openLicenseId,openLicensePath,taxRegisterId,reviewState) "
			+ "VALUES(?,?,?,?,?,?,?,?,0);";
	private static final String UPDATE_COMPANY_BYCOMID = "UPDATE tbl_company_info SET companyName = ?,legalPerson = ?,phoneNumber = ?,bankAccount = ?,openLicenseId = ?, openLicensePath = ?,taxRegisterId = ?,reviewState = ? " 
			+"WHERE  companyId= ? ";

	private static final String QUERY_COMPANY_BYCOMID = "SELECT * FROM tbl_company_info "
			+"WHERE companyId = '%s'";
	@Override
	public User queryUserByName(String name) throws SQLException
	{
		String s = String.format(QUERY_USER, name);
		List<User> userList = this.query(String.format(QUERY_USER, name), User.class);
		return userList.size() > 0 ? userList.get(0) : null;
	}

	@Override
	public User queryUserByCompanyId(String companyId) throws SQLException
	{
		String s = String.format(QUERY_COMP, companyId);
		List<User> userList = this.query(String.format(QUERY_COMP, companyId), User.class);
		return userList.size() > 0 ? userList.get(0) : null;
	}

	@Override
	public boolean insertUser(User user) throws SQLException
	{
		int state = this.insert(INSERT_USER,
				new Object[] { user.getName(), user.getPassword(), user.getPermission(), user.getCompanyId() });
		return state > 0? true : false;
	}

	@Override
	public boolean insertCompany(Company company) throws SQLException
	{
		int state = this.insert(INSERT_COMPANY,
				new Object[] { company.getCompanyId(),company.getCompanyName(),company.getLegalPerson(),company.getPhoneNumber(),
						company.getBankAccount(),company.getOpenLicenseId(),company.getOpenLicensePath(),company.getTaxRegisterId()});
		return state > 0 ? true : false;
	}
	/**
	 * 校验用户名是否 未被注册
	 * 
	 * @param loginname
	 * @return
	 * @throws SQLException
	 */
	@Override
	public boolean ajaxValidateLoginname(String name) throws SQLException
	{
		if (queryUserByName(name) == null)
			return false;
		else
			return true;

	}

	@Override
	public boolean ajaxValidateCompanyId(String companyId) throws SQLException
	{
		if (queryUserByCompanyId(companyId) != null)
			return false;
		else
			return true;

	}

	@Override
	public boolean ajaxValidateLoginpassword(String name, String password) throws SQLException
	{
		User user = new User();
		user = queryUserByName(name);
		if (user != null)
		{
			if (StringUtils.equals(user.getPassword(), password))
			{
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean ajaxValidateLoginState(String name) throws SQLException
	{
		User user = new User();
		user = queryUserByName(name);
		if (user != null)
		{
			if (user.isLoginState() == true)
			{
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean updateUser_loginstate_ByName(User user) throws SQLException
	{
		int state = this.update(UPDATA_USER_STATE, new Object[] { user.isLoginState(), user.getName() });
		System.out.println("userdaoimplement.getname" + user.getName());
		System.out.println("userdaoimplement.getPassword:" + user.getPassword());
		System.out.println("userdaoimplement.getloginstate:" + user.isLoginState());
		System.out.println("userdaoimplement.state：" + state);
		return state > 0 ? true : false;
	}

	@Override
	public List<User> queryManager() throws SQLException
	{
		List<User> managerList = this.query(QUERY_MANAGER, User.class);
		return managerList.size() > 0 ? managerList : null;
	}

	@Override
	public boolean addManager(User manager) throws SQLException
	{
		int addmanager = this.insert(INSERT_MANAGER,
				new Object[] { manager.getName(), manager.getPassword(), manager.getPermission() });
		return addmanager > 0 ? true : false;
	}

	@Override
	public boolean deleteManager(String id) throws SQLException
	{
		int deletemanager = this.insert(DELETE_MANAGER, new Object[] { id });
		return deletemanager > 0 ? true : false;
	}

	@Override
	public int queryLevelById(String id) throws SQLException
	{
		return (int) this.query("level", String.format(QUERY_LEVEL_ById, id));
	}
	//公司dao实现
	@Override
	public boolean updateCompany(Company company) throws SQLException {
		int state = this.update(UPDATE_COMPANY_BYCOMID, new Object[]{company.getCompanyName(),company.getLegalPerson(),company.getPhoneNumber(),company.getBankAccount(),company.getOpenLicenseId(),company.getOpenLicensePath(),company.getTaxRegisterId(),company.getReviewState(), company.getCompanyId()});
		return state > 0 ? true : false;
	}
	@Override
	public Company queryCompanyByCompanyID(String companyId) throws SQLException {
		List<Company> companylist = this.query(String.format(QUERY_COMPANY_BYCOMID, companyId), Company.class);
		return companylist.size() > 0 ? companylist.get(0) : null;
	}
}
