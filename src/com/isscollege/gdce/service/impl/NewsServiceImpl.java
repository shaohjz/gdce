package com.isscollege.gdce.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.isscollege.gdce.dao.INewsDao;
import com.isscollege.gdce.dao.impl.NewsDaoImpl;
import com.isscollege.gdce.domain.News;
import com.isscollege.gdce.domain.NewsPageBean;
import com.isscollege.gdce.service.INewsService;


public class NewsServiceImpl implements INewsService{
	private INewsDao dao;
	
	public NewsServiceImpl()
	{
		dao = new NewsDaoImpl();
	}

	@Override
	public boolean addNews(News news) {
		// TODO Auto-generated method stub
		return dao.addNews(news)>0 ? true :false;
	}

	@Override
	public List<News> getNewsByTitle(String title) {
		// TODO Auto-generated method stub
		return dao.getNewsByTitle(title);
	}
	
	@Override
	public boolean updateNews(News news) {
		// TODO Auto-generated method stub
		return dao.updateNews(news)>0 ? true :false;
	}
	
	@Override
	public List<News> getAllNews(String type,int page) {
		int totalCount = dao.count(type);
		return dao.getAllNews(type,page);
	}

	@Override
	public List<News> getNewsByType(String type) throws SQLException
	{
		// TODO Auto-generated method stub
		return dao.getNewsByType(type);
	}

	@Override
	public NewsPageBean findPageBean(int currentPage, int currentCount,String type)
	{
		NewsPageBean pageBean=new NewsPageBean();
		//1.��ǰҳ
		pageBean.setCurrentPage(currentPage);
		//2.��ǰҳ����
		pageBean.setCurrentCount(currentCount);
		//3.�ܼ�¼��
		int totalCount=dao.count(type);
		pageBean.setTotalCount(totalCount);
		//4.�ֶ���ҳ
		int totalPage=(int)Math.ceil(1.0*totalCount/currentCount);
		pageBean.setTotalPage(totalPage);
		//5.ÿҳ��ʾ������
		int index=(currentPage-1)*currentCount;
		List<News> newsList=dao.findPageBeanForNews(index,currentCount,type);
		
		pageBean.setNewsList(newsList);
		
		return pageBean;
	}

	@Override
	public News newsDisplay(String title)
	{
		News news = dao.newsDisplay(title);
		return news;
	}

	@Override
	public NewsPageBean adminPageBean(int currentPage, int currentCount, String type)
	{
		NewsPageBean pageBean=new NewsPageBean();
		//1.��ǰҳ
		pageBean.setCurrentPage(currentPage);
		//2.��ǰҳ����
		pageBean.setCurrentCount(currentCount);
		//3.�ܼ�¼��
		int totalCount=dao.count(type);
		pageBean.setTotalCount(totalCount);
		
		int totalPage=(int)Math.ceil(1.0*totalCount/currentCount);
		pageBean.setTotalPage(totalPage);
		//5.ÿҳ��ʾ������
		int index=(currentPage-1)*currentCount;
		List<News> newsList=dao.adminPageBeanForNews(index,currentCount,type);
		pageBean.setNewsList(newsList);
		return pageBean;	
		
	}


}
