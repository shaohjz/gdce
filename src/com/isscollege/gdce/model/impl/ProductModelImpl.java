package com.isscollege.gdce.model.impl;

import java.sql.*;
import java.util.List;

import com.isscollege.gdce.domain.Product;
import com.isscollege.gdce.model.IProductModel;
import com.isscollege.gdce.service.IProductService;
import com.isscollege.gdce.service.impl.ProductServiceImpl;

public class ProductModelImpl implements IProductModel
{
	 Connection conn = null;
	 Statement stmt = null;
	 ResultSet rs = null;
	 String DB = "gdce"; //数据库名
	 String user = "root";//用户名
	 String password = "root"; //密码
	 String setcharcter = "utf8"; //数据库字符

	 /**
	  * 关闭所有数据库连接相关对象
	  */ 
	 public void closeAll()
	    {
		 try{
	  if (rs != null) {
	   rs.close();
	  }
	  if (stmt != null) {
	   stmt.close();
	  }
	  if (conn != null && !conn.isClosed()) {
	   conn.close();
	  }
	} catch (SQLException ex)
		 {
		ex.printStackTrace();
		 }
		 
	 }
	
	private IProductService service;

	public ProductModelImpl()
	{
		service = new ProductServiceImpl();
	}

	@Override
	public int insertProduct(Product product)
	{
		return service.insertProduct(product);
	}

	@Override
	public boolean  updateProduct(Product product){
		return service.updateProduct(product);
	}

	@Override
	public List<Product> getResult()
	{
		
		return service.getResult();
	}

}
