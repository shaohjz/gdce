package com.isscollege.gdce.service;

import java.util.List;

import com.isscollege.gdce.domain.Product;
import com.isscollege.gdce.domain.User;

public interface ITradeService
{

	List<Product> getProductInfo(int productId);

	Object getPhoneNumber(int productId);

	boolean updateProductState(int productId);

	String getCompanyIdByName(String name);
}
