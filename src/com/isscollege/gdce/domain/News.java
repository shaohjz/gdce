package com.isscollege.gdce.domain;

public class News {

	//�û�����
	private String name;
	//��Ѷ����
	private String title;
	//��Ѷ����(�������:hgzc���г�����:scfx��������ҵ:dlhy��ú̿�۸�:mtjg)
	private String type;
	//���״̬(0-����ˡ�1-���ͨ����2-��˲�ͨ��)
	private int reviewState;
	//��Ѷ����ʱ��
	private String createDate;
	//��Ѷ����
	private String content;
	//��Ѷid
	private int id;
	
	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public News() 
	{
		super();
	}
	
	public String getName() 
	{
		return name;
	}
	
	public void setName(String name) 
	{
		this.name = name;
	}
	
	public String getTitle() 
	{
		return title;
	}
	
	public void setTitle(String title) 
	{
		this.title = title;
	}
	
	public String getType() 
	{
		return type;
	}
	
	public void setType(String type) 
	{
		this.type = type;
	}
	
	public int getReviewState() 
	{
		return reviewState;
	}
	
	public void setReviewState(int reviewState) 
	{
		this.reviewState = reviewState;
	}
	
	public String getCreateDate() 
	{
		return createDate;
	}
	
	public void setCreateDate(String createDate) 
	{
		this.createDate = createDate;
	}
	
	public String getContent() 
	{
		return content;
	}
	
	public void setContent(String content) 
	{
		this.content = content;
	}
	
}
