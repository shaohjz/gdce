package com.isscollege.gdce.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.isscollege.gdce.dao.ITradeDao;
import com.isscollege.gdce.dao.IUserDao;
import com.isscollege.gdce.dao.impl.TradeDaoImpl;
import com.isscollege.gdce.dao.impl.UserDaoImpl;
import com.isscollege.gdce.domain.Product;
import com.isscollege.gdce.domain.User;
import com.isscollege.gdce.service.ITradeService;

public class TradeServiceImpl implements ITradeService
{
	private ITradeDao dao;
	private IUserDao userDao;

	public TradeServiceImpl()
	{
		dao = new TradeDaoImpl();
		userDao = new UserDaoImpl();
	}

	public List<Product> getProductInfo(int productId)
	{
		try
		{
			return dao.getProductInfo(productId);
		} catch (SQLException e)
		{
			e.printStackTrace();
			return null;
		}
	}

	public Object getPhoneNumber(int productId)
	{
		try
		{
			return dao.getPhoneNumber(productId);
		} catch (SQLException e)
		{
			e.printStackTrace();
			return null;
		}
	}

	public boolean updateProductState(int productId)
	{
		try
		{
			return dao.updateProductState(productId);
		} catch (SQLException e)
		{

			e.printStackTrace();
		}
		return false;

	}

	public String getCompanyIdByName(String name)
	{
		User TempUser = new User();

		try
		{
			TempUser = userDao.queryUserByName(name);
			return TempUser.getCompanyId();
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		return null;
	}

}
