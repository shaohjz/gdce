package com.isscollege.gdce.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.isscollege.gdce.common.dao.impl.BasicDao;
import com.isscollege.gdce.dao.INewsDao;
import com.isscollege.gdce.domain.News;

public class NewsDaoImpl extends BasicDao implements INewsDao
{

	private static final String QUERY_UNREVIEW_NEWS = "SELECT * FROM tbl_news_info WHERE reviewState=0 ORDER BY id ASC LIMIT %d,%d";
	private static final String UPDATE_NEWS_REVIEW_STATE = "UPDATE tbl_news_info SET reviewState=%d WHERE id=%d";

	@Override
	public int addNews(News news)
	{
		int i = 0;
		String sql = "INSERT INTO tbl_news_info(name,title,type,reviewState,createDate,content) VALUES(?,?,?,?,?,?);";

		try
		{
			i = this.insert(sql, new Object[] { news.getName(), news.getTitle(), news.getType(), news.getReviewState(),
					news.getCreateDate(), news.getContent() });
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public List<News> getNewsByTitle(String title)
	{
		String sql = "SELECT * FROM tbl_news_info WHERE title =" + "'" + title + "'";
		List<News> news = null;
		// TODO Auto-generated method stub
		try
		{
			news = this.query(sql, News.class);
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return news;
	}

	@Override
	public int updateNews(News news)
	{
		int i = 0;
		String sql = "UPDATE tbl_news_info SET title=?,content=?, createDate=?, reviewState=? WHERE id=?";

		try
		{
			i = this.update(sql, new Object[] { news.getTitle(), news.getContent(), news.getCreateDate(),
					news.getReviewState(), news.getId() });
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public List<News> getAllNews(String type, int page)
	{
		String sql = "select * from tbl_news_info where type=" + "'" + type + "'" + " limit " + 0 + "," + 8;
		List<News> news = null;

		try
		{
			news = this.query(sql, News.class);
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return news;
	}

	@Override
	public List<News> queryNewsByReviewState(int page, int size)
	{
		List<News> newsList = null;

		try
		{
			newsList = this.query(String.format(QUERY_UNREVIEW_NEWS, page, size), News.class);
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		return newsList;
	}

	@Override
	public void updateNewsReviewState(int newsId, int curStats)
	{

		try
		{
			this.update(String.format(UPDATE_NEWS_REVIEW_STATE, curStats, newsId), null);
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public List<News> getNewsByType(String type) throws SQLException
	{
		String sql = "SELECT * FROM tbl_news_info WHERE type =" + "'" + type + "'";
		// TODO Auto-generated method stub
		return this.query(sql, News.class);
	}

	@Override
	public int count(String type)
	{
		// System.out.println(type);
		// ��ѯ����
		String sql = "select * from tbl_news_info where type=" + "'" + type + "'";
		List<News> list = null;

		try
		{
			list = this.query(sql, News.class);
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list.size();
	}

	@Override
	public List<News> findPageBeanForNews(int index, int currentCount, String type)
	{
		String sql = "select * from tbl_news_info where reviewState=1 and type=" + "'" + type + "'" + " limit " + index
				+ "," + currentCount;
		List<News> newsList = null;

		try
		{
			newsList = this.query(sql, News.class);
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return newsList;
	}

	@Override
	public News newsDisplay(String title)
	{
		String sql = "select * from tbl_news_info where title=" + "'" + title + "'";
		List<News> news = null;

		try
		{
			news = this.query(sql, News.class);
			System.out.println("news" + news.size());
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return news.get(0);
	}

	@Override
	public List<News> adminPageBeanForNews(int index, int currentCount, String type)
	{
		String sql = "select * from tbl_news_info where type=" + "'" + type + "'" + " limit " + index + ","
				+ currentCount;
		List<News> newsList = null;

		try
		{
			newsList = this.query(sql, News.class);
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return newsList;
	}

}
