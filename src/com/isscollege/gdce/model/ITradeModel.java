package com.isscollege.gdce.model;

import java.util.List;

import com.isscollege.gdce.domain.Product;
import com.isscollege.gdce.domain.User;

public interface ITradeModel
{
	List<Product> getProductInfo(int productId);

	Object getPhoneNumber(int productId);

	boolean updateProductState(int productId);

	String getCompanyIdByName(String name);
}
