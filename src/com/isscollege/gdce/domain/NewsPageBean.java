package com.isscollege.gdce.domain;

import java.util.ArrayList;
import java.util.List;

public class NewsPageBean
{	//1����ǰҳ
	private int currentPage;
	//2.��ǰ��������
	private int currentCount;
	//3.��������
	private int totalCount;
	//4.��ҳ��
	private int totalPage;
	//5.��װ������
	private List<News> newsList=new ArrayList();
	public int getCurrentPage()
	{
		return currentPage;
	}
	public void setCurrentPage(int currentPage)
	{
		this.currentPage = currentPage;
	}
	public int getCurrentCount()
	{
		return currentCount;
	}
	public void setCurrentCount(int currentCount)
	{
		this.currentCount = currentCount;
	}
	public int getTotalCount()
	{
		return totalCount;
	}
	public void setTotalCount(int totalCount)
	{
		this.totalCount = totalCount;
	}
	public int getTotalPage()
	{
		return totalPage;
	}
	public void setTotalPage(int totalPage)
	{
		this.totalPage = totalPage;
	}
	public List<News> getNewsList()
	{
		return newsList;
	}
	public void setNewsList(List<News> newsList)
	{
		this.newsList = newsList;
	}
	
	
}
