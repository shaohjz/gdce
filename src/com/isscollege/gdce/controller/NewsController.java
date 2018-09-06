package com.isscollege.gdce.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;



import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.StringUtils;

import com.isscollege.gdce.domain.News;
import com.isscollege.gdce.domain.NewsPageBean;
import com.isscollege.gdce.model.INewsModel;
import com.isscollege.gdce.model.impl.NewsModelImpl;

@WebServlet("/news")
public class NewsController extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	private INewsModel model;
	//子功能分发
	private String forward = "";

	public NewsController()
	{
		model = new NewsModelImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		forward = request.getParameter("forward");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
	
		
		if(StringUtils.isNotEmpty(forward)
				&& StringUtils.equals(forward, "addNews"))
		{
			addNews(request,response);
		}
		else if(StringUtils.isNotEmpty(forward)
				&& StringUtils.equals(forward, "newsDisplay"))
		{
			try
			{
				newsDisplay(request,response);
			} catch (SQLException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(StringUtils.isNotEmpty(forward)
				&& StringUtils.equals(forward, "queryNews"))
		{
			queryNews(request,response);
		}
		else if(StringUtils.isNotEmpty(forward)
				&& StringUtils.equals(forward, "findPageBean"))
		{
			try
			{
				findPageBean(request,response);
			} 
			catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
		else if(StringUtils.isNotEmpty(forward)
				&& StringUtils.equals(forward, "getNewsByTitle"))
		{
			getNewsByTitle(request,response);
		}
		else if(StringUtils.isNotEmpty(forward)
				&& StringUtils.equals(forward, "adminPageBean"))
		{
			try
			{
				adminPageBean(request,response);
			} catch (SQLException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(StringUtils.isNotEmpty(forward)
				&& StringUtils.equals(forward, "modify"))
		{
			modifyNews(request,response);
		}

	}

	private void addNews(HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException	
	{	
		News news = new News();
		Date day=new Date();    
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		
		String type=(String)request.getParameter("type");
		String username=(String)request.getParameter("username");		
		String title = (String)request.getParameter("title");
		String content = (String)request.getParameter("content");
		
		username=new String(username.getBytes("ISO-8859-1"), "UTF-8");
		title=new String(title.getBytes("ISO-8859-1"), "UTF-8");
		content=new String(content.getBytes("ISO-8859-1"), "UTF-8");
		
		news.setType(type);
		news.setName(username);
		news.setTitle(title);
		news.setContent(content);
		news.setCreateDate(df.format(day));
		news.setReviewState(0);
		
		model.addNews(news);
		try {
			request.getRequestDispatcher("/jsp/news/newsManage.jsp").forward(request,response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private void getNewsByTitle(HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException
	{
		String title = request.getParameter("title");	
		title=new String(title.getBytes("ISO-8859-1"), "UTF-8");
		
		List<News> news = model.getNewsByTitle(title);
        String type=news.get(0).getType();
       
        switch(type)
        {
        	case"hgzc": type="宏观政策" ;  
        				break;
        	case"scfx": type="市场分析" ;  
        				break;
        	case"dlhy": type="电力行业" ; 
        				break;
        	case"mtjg": type="煤炭价格" ;  
        				break;
        }
        
		request.setAttribute("id",news.get(0).getId());
		request.setAttribute("type", type);
		request.setAttribute("username", news.get(0).getName());
		request.setAttribute("title", title);
		request.setAttribute("content", news.get(0).getContent());
		
		try {
			request.getRequestDispatcher("/jsp/news/newsModify.jsp").forward(request,response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	private void modifyNews(HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException
	{
		News news = new News();
		Date day=new Date();    
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
							
		String title = (String)request.getParameter("title");
		String content = (String)request.getParameter("content");
		int id=Integer.parseInt(request.getParameter("id"));
		
		title=new String(title.getBytes("ISO-8859-1"), "UTF-8");
		content=new String(content.getBytes("ISO-8859-1"), "UTF-8");		  
		
		news.setId(id);
		news.setTitle(title);
		news.setContent(content);
		news.setCreateDate(df.format(day));
		news.setReviewState(0);
		
		model.updateNews(news);
		
		try {
			request.getRequestDispatcher("/jsp/news/newsManage.jsp").forward(request,response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private void queryNews(HttpServletRequest request,HttpServletResponse response)
	{	
		
		String type = request.getParameter("type");	
		String page0=request.getParameter("page");
		int page=Integer.valueOf(page0).intValue();
		
		List<News> newsAll = model.getAllNews(type, page);
		request.setAttribute("newsAll", newsAll);

		try 
		{
			request.getRequestDispatcher("/jsp/news/newsManage.jsp").forward(request,response);
		} 
		catch (ServletException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private void getNewsByType(HttpServletRequest request,HttpServletResponse response) throws SQLException
	{
		String type = request.getParameter("type");
		System.out.println(forward);
		System.out.println(type);
        List<News> news = null;
        
        try 
        {
            news = model.getNewsByType(type);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
       
        request.setAttribute("news", news);
        
        try
		{
			request.getRequestDispatcher("/jsp/news/newsCenter.jsp").forward(request,response);
		} 
        catch (ServletException e)
		{
			e.printStackTrace();
		}
        catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	private void findPageBean(HttpServletRequest request,HttpServletResponse response) throws SQLException
	{
		//模拟当前是第一页
		String currentPageStr = request.getParameter("currentPage");
		String type = request.getParameter("type");
		
		if(currentPageStr==null) 
		{
			currentPageStr="1";
		}
		
		int currentPage = Integer.parseInt(currentPageStr);
		//认为每页显示8条
		int currentCount = 8;
		
		NewsPageBean pageBean = null;
		//System.out.println(type);System.out.println(currentPage);System.out.println(currentCount);
		
		pageBean = model.findPageBean(currentPage,currentCount,type);
		
		request.setAttribute("pageBean", pageBean);
		request.setAttribute("type", type);
		
		try
		{
			request.getRequestDispatcher("/jsp/news/newsCenter.jsp").forward(request, response);
		} catch (ServletException e)
		{
			e.printStackTrace();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	private void newsDisplay(HttpServletRequest request,HttpServletResponse response) throws SQLException, UnsupportedEncodingException
	{
		String title = request.getParameter("title");
		//byte[] bytes = title.getBytes("ISO-8859-1");
		
		try
		{
			title=new String(title.getBytes("ISO-8859-1"), "UTF-8");
		} catch (UnsupportedEncodingException e1)
		{
			e1.printStackTrace();
		}
		String type = request.getParameter("type");
		News news = model.newsDisplay(title);
		
		request.setAttribute("news", news);
		
		
		if("hgzc".equals(type))
		{
			type="宏观政策";
		}
		else if("scfx".equals(type))
		{ 
			type="市场分析";
		}
		else if("dlhy".equals(type))
		{ 
			type="电力行业";
		}
		else if("mtjg".equals(type))
		{
			type="煤炭价格";
		}

		request.setAttribute("type", type);
		
		try
		{
			request.getRequestDispatcher("/jsp/news/newsDisplay.jsp").forward(request, response);
		} catch (ServletException e)
		{
			e.printStackTrace();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	private void adminPageBean(HttpServletRequest request,HttpServletResponse response) throws SQLException
	{
		String currentPageStr = request.getParameter("currentPage");
		String type = request.getParameter("type");
		
		if(currentPageStr==null) 
		{
			currentPageStr="1";
		}
		
		int currentPage = Integer.parseInt(currentPageStr);
		//认为每页显示8条
		int currentCount = 8;
		
		NewsPageBean pageBean = null;
		pageBean = model.adminPageBean(currentPage,currentCount,type);
		
		request.setAttribute("pageBean", pageBean);
		request.setAttribute("type", type);
		
		try
		{
			request.getRequestDispatcher("/jsp/news/newsManage.jsp").forward(request, response);
		} catch (ServletException e)
		{
			e.printStackTrace();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}
	

