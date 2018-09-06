package com.isscollege.gdce.model.impl;

import java.sql.SQLException;
import java.util.List;

import com.isscollege.gdce.domain.Advertisement;
import com.isscollege.gdce.domain.Company;
import com.isscollege.gdce.domain.News;
import com.isscollege.gdce.domain.Product;
import com.isscollege.gdce.model.IReviewModel;
import com.isscollege.gdce.service.IReviewService;
import com.isscollege.gdce.service.impl.ReviewServiceImpl;

public class ReviewModelImpl implements IReviewModel
{

	private IReviewService service = null;

	public ReviewModelImpl()
	{
		service = new ReviewServiceImpl();
	}

	@Override
	public List<Advertisement> queryAdvertisementByReviewState(int page, int size) throws SQLException
	{
		return service.queryAdvertisementByReviewState(page, size);
	}

	@Override
	public void updateAdvertisementReviewState(int advertisementId, int curStats) throws SQLException
	{
		service.updateAdvertisementReviewState(advertisementId, curStats);
		;
	}

	@Override
	public List<Company> queryCompanyByReviewState(int page, int size) throws SQLException
	{
		return service.queryCompanyByReviewState(page, size);
	}

	@Override
	public void updateCompanyReviewState(int companyId, int curStats) throws SQLException
	{
		service.updateCompanyReviewState(companyId, curStats);
		;
	}

	@Override
	public List<Product> queryProductByReviewState(int page, int size) throws SQLException
	{
		return service.queryProductByReviewState(page, size);
	}

	@Override
	public void updateProductReviewState(int productId, int curStats) throws SQLException
	{
		service.updateProductReviewState(productId, curStats);
	}

	@Override
	public List<News> queryNewsByReviewState(int page, int size) throws SQLException
	{
		return service.queryNewsByReviewState(page, size);
	}

	@Override
	public void updateNewsReviewState(int newsId, int curStats) throws SQLException
	{
		service.updateNewsReviewState(newsId, curStats);
	}
}
