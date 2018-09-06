package com.isscollege.gdce.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.isscollege.gdce.dao.IProductDao;
import com.isscollege.gdce.dao.impl.ProductDaoImpl;
import com.isscollege.gdce.domain.Product;
import com.isscollege.gdce.service.IProductService;

public class ProductServiceImpl implements IProductService 
{
	private IProductDao dao;

	public ProductServiceImpl()
	{
		dao = new ProductDaoImpl();
	}

	@Override
	public int insertProduct(Product product)
	{
		try 
		{
			return dao.insertProduct(product);
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public boolean updateProduct(Product product)
	{
		try 
		{
			return dao.updateProduct(product);
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<Product> getResult()
	{
		List<Product> productlist = new ArrayList<Product>();
		try 
		{
			 productlist=dao.getResult();
			 return productlist;
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
			return productlist;
		}
	}



}