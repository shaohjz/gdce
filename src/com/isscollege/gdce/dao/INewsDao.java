package com.isscollege.gdce.dao;

import java.sql.SQLException;
import java.util.List;

import com.isscollege.gdce.domain.News;

public interface INewsDao
{

	int addNews(News news);

	List<News> getAllNews(String type, int page);

	// ��˹��ܲ�ѯ����
	List<News> queryNewsByReviewState(int page, int size);

	// ��˹��ܸ��·���
	void updateNewsReviewState(int newsId, int curStats);

	List<News> getNewsByType(String type) throws SQLException;

	int count(String type);

	List<News> findPageBeanForNews(int index, int currentCount, String type);

	List<News> getNewsByTitle(String title);

	int updateNews(News news);

	News newsDisplay(String title);

	List<News> adminPageBeanForNews(int index, int currentCount, String type);
}
