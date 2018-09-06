package com.isscollege.gdce.service;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.isscollege.gdce.domain.News;
import com.isscollege.gdce.domain.NewsPageBean;

public interface INewsService {

	boolean addNews(News news);

	List<News> getAllNews(String type,int page);

    List<News> getNewsByType(String type) throws SQLException;

	NewsPageBean findPageBean(int currentPage, int currentCount,String type);
	
	List<News> getNewsByTitle(String title);
	
	boolean updateNews(News news);

	News newsDisplay(String title);

	NewsPageBean adminPageBean(int currentPage, int currentCount, String type);
}
