package com.isscollege.gdce.service.impl;

import java.util.List;

import com.isscollege.gdce.dao.IAdvertisementDao;
import com.isscollege.gdce.dao.ICompanyDao;
import com.isscollege.gdce.dao.INewsDao;
import com.isscollege.gdce.dao.IProductDao;
import com.isscollege.gdce.dao.impl.AdvertisementDaoImpl;
import com.isscollege.gdce.dao.impl.CompanyDaoImpl;
import com.isscollege.gdce.dao.impl.NewsDaoImpl;
import com.isscollege.gdce.dao.impl.ProductDaoImpl;
import com.isscollege.gdce.domain.Advertisement;
import com.isscollege.gdce.domain.Company;
import com.isscollege.gdce.domain.News;
import com.isscollege.gdce.domain.Product;
import com.isscollege.gdce.service.IReviewService;
import java.sql.SQLException;

public class ReviewServiceImpl implements IReviewService
{

	private IProductDao productDao;
	private ICompanyDao companyDao;
	private IAdvertisementDao advertisementDao;
	private INewsDao newsDao;

	public ReviewServiceImpl()
	{
		productDao = new ProductDaoImpl();
		companyDao = new CompanyDaoImpl();
		advertisementDao = new AdvertisementDaoImpl();
		newsDao = new NewsDaoImpl();
	}

	@Override
	public List<Advertisement> queryAdvertisementByReviewState(int page, int size) throws SQLException
	{
		return advertisementDao.queryAdvertisementByReviewState(page, size);
	}

	@Override
	public void updateAdvertisementReviewState(int advertisementId, int curStats) throws SQLException
	{
		advertisementDao.updateAdvertisementReviewState(advertisementId, curStats);
	}

	@Override
	public List<Company> queryCompanyByReviewState(int page, int size) throws SQLException
	{
		return companyDao.queryCompanyByReviewState(page, size);
	}

	@Override
	public void updateCompanyReviewState(int companyId, int curStats) throws SQLException
	{
		companyDao.updateCompanyReviewState(companyId, curStats);
	}

	@Override
	public List<Product> queryProductByReviewState(int page, int size) throws SQLException
	{
		return productDao.queryProductByReviewState(page, size);
	}

	@Override
	public void updateProductReviewState(int productId, int curStats) throws SQLException
	{
		productDao.updateProductReviewState(productId, curStats);
	}

	@Override
	public List<News> queryNewsByReviewState(int page, int size) throws SQLException
	{
		return newsDao.queryNewsByReviewState(page, size);
	}

	@Override
	public void updateNewsReviewState(int newsId, int curStats) throws SQLException
	{
		newsDao.updateNewsReviewState(newsId, curStats);
	}
}
