package com.isscollege.gdce.model;

import java.sql.SQLException;
import java.util.List;

import com.isscollege.gdce.domain.Advertisement;
import com.isscollege.gdce.domain.Company;
import com.isscollege.gdce.domain.News;
import com.isscollege.gdce.domain.Product;

public interface IReviewModel
{

	List<Product> queryProductByReviewState(int page, int size) throws SQLException;

	void updateProductReviewState(int productId, int curStats) throws SQLException;

	List<Advertisement> queryAdvertisementByReviewState(int page, int size) throws SQLException;

	void updateAdvertisementReviewState(int advertisementId, int curStats) throws SQLException;

	List<Company> queryCompanyByReviewState(int page, int size) throws SQLException;

	void updateCompanyReviewState(int companyId, int curStats) throws SQLException;

	List<News> queryNewsByReviewState(int page, int size) throws SQLException;

	void updateNewsReviewState(int newsId, int curStats) throws SQLException;
}
