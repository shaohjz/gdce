package com.isscollege.gdce.model.impl;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.isscollege.gdce.domain.News;
import com.isscollege.gdce.domain.NewsPageBean;
import com.isscollege.gdce.model.INewsModel;
import com.isscollege.gdce.service.INewsService;
import com.isscollege.gdce.service.impl.NewsServiceImpl;

public  class NewsModelImpl implements INewsModel{

	private INewsService service;
	
	public NewsModelImpl()
	{
		service = new NewsServiceImpl();
	}

	@Override
	public boolean addNews(News news) {
		// TODO Auto-generated method stub
		return service.addNews(news);
	}
   
	public boolean updateNews(News news)
    {
    	return service.updateNews(news);
    }

	@Override
	public List<News> getAllNews(String type,int page) {
		
		return service.getAllNews(type,page);
	}

	@Override
	public List<News> getNewsByType(String type) throws SQLException
	{
		// TODO Auto-generated method stub
		return service.getNewsByType(type);
	}

	@Override
	//·ÖÒ³´úÂë
	public NewsPageBean findPageBean(int currentPage, int currentCount,String type)
	{
		
		return service.findPageBean(currentPage,currentCount,type);
	}

		@Override
	public List<News> getNewsByTitle(String title) {
		// TODO Auto-generated method stub
		return service.getNewsByTitle(title);
	}

	@Override
	public News newsDisplay(String title)
	{
		News news=service.newsDisplay(title);
		return news;
	}

	@Override
	public NewsPageBean adminPageBean(int currentPage, int currentCount, String type)
	{
		
		 return service.adminPageBean(currentPage,currentCount,type);
	}
}
