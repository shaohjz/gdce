package com.isscollege.gdce.model;

import java.sql.*;
import java.util.List;

import com.isscollege.gdce.domain.Product;

public interface IProductModel 
{
	int insertProduct(Product product);
	boolean updateProduct(Product product) ;
	List<Product> getResult();
}