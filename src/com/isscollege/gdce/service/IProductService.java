package com.isscollege.gdce.service;

import java.util.List;

import com.isscollege.gdce.domain.Product;

public interface IProductService 
{
	int insertProduct(Product product);
	 boolean updateProduct(Product Product) ;
	 List<Product> getResult();
}
