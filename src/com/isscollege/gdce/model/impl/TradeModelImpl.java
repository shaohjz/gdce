package com.isscollege.gdce.model.impl;

import java.util.List;

import com.isscollege.gdce.domain.Product;
import com.isscollege.gdce.domain.User;
import com.isscollege.gdce.model.ITradeModel;
import com.isscollege.gdce.service.ITradeService;
import com.isscollege.gdce.service.impl.TradeServiceImpl;

public class TradeModelImpl implements ITradeModel
{
	private ITradeService server;

	public TradeModelImpl()
	{
		server = new TradeServiceImpl();
	}

	@Override
	public List<Product> getProductInfo(int productId)
	{
		return server.getProductInfo(productId);
	}

	public Object getPhoneNumber(int productId)
	{
		return server.getPhoneNumber(productId);
	}

	public boolean updateProductState(int productId)
	{
		return server.updateProductState(productId);
	}

	@Override
	public String getCompanyIdByName(String name)
	{

		return server.getCompanyIdByName(name);
	}
}
