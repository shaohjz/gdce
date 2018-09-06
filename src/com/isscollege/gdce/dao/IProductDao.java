package com.isscollege.gdce.dao;

import java.sql.SQLException;
import java.util.List;


import com.isscollege.gdce.domain.Product;

public interface IProductDao
{	 

   int insertProduct(Product product) throws SQLException;
   boolean updateProduct(Product product) throws SQLException;
   List<Product> getResult() throws SQLException;
   
   public List<Product> queryProductByReviewState(int page, int size) throws SQLException;
   public void updateProductReviewState(int productId, int curStats) throws SQLException;

}
