package com.isscollege.gdce.dao;

import java.sql.SQLException;
import java.util.List;

import com.isscollege.gdce.domain.Product;

public interface ITradeDao
{
	List<Product> getProductInfo(int productId) throws SQLException;

	Object getPhoneNumber(int productId) throws SQLException;

	public boolean updateProductState(int productId) throws SQLException;

}
