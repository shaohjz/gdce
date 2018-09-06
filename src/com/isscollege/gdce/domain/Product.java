package com.isscollege.gdce.domain;

public class Product
{
	private int id;
	private int productId;
	private int productState;
	private String productType;
	private String srcAddress;
	private String destAddress;
	private float price;
	private float quantity;
	private String createDate;
	private String endDate;
	private float fullMoisture;
	private float fullSulfur;
	private float volatiles;
	private String transactionMode;
	private int lowPower;
	private String userName;
	private int reviewState;
	private String remark;

	public Product()
	{
		
	}
	
	public Product(int id,int productId,int productState,String productType,String srcAddress,String destAddress,float price,
		 float quantity,String createDate,String endDate,float fullMoisture,float fullSulfur,
		 float volatiles,String transactionMode,int lowPower,String userName,int reviewState,
		 String remark)
	{
		
	}
	
	public int getId()
	{
		return this.id;
	}

	public void setId(int id)
	{
		this.id=id;
	}
	
	public int getproductId()
	{
		return this.productId;
	}

	public void setProductId(int productId)
	{
		this.productId=productId;
	}
	
	public int getProductState()
	{
		return this.productState;
	}

	public void setProductState(int productState)
	{
		this.productState=productState;
	}
	
	public String getProductType()
	{
		return this.productType;
	}

	public void setProductType(String productType)
	{
		this.productType=productType;
	}
	
	public String getSrcAddress()
	{
		return this.srcAddress;
	}

	public void setSrcAddress(String srcAddress)
	{
		this.srcAddress=srcAddress;
	}
	
	public String getDestAddress()
	{
		return this.destAddress;
	}

	public void setDestAddress(String destAddress)
	{
		this.destAddress=destAddress;
	}

	public float getPrice()
	{
		return price;
	}

	public void setPrice(float price)
	{
		this.price = price;
	}

	public float getQuantity()
	{
		return quantity;
	}

	public void setQuantity(float quantity)
	{
		this.quantity = quantity;
	}

	public String getCreateDate()
	{
		return createDate;
	}

	public void setCreateDate(String createDate)
	{
		this.createDate = createDate;
	}

	public String getEndDate()
	{
		return endDate;
	}

	public void setEndDate(String endDate)
	{
		this.endDate = endDate;
	}

	public float getFullMoisture()
	{
		return fullMoisture;
	}

	public void setFullMoisture(float fullMoisture)
	{
		this.fullMoisture = fullMoisture;
	}

	public float getFullSulfur()
	{
		return fullSulfur;
	}

	public void setFullSulfur(float fullSulfur)
	{
		this.fullSulfur = fullSulfur;
	}

	public float getVolatiles()
	{
		return volatiles;
	}

	public void setVolatiles(float volatiles)
	{
		this.volatiles = volatiles;
	}

	public String getTransactionMode()
	{
		return transactionMode;
	}

	public void setTransactionMode(String transactionMode)
	{
		this.transactionMode = transactionMode;
	}

	public int getLowPower()
	{
		return lowPower;
	}

	public void setLowPower(int lowPower)
	{
		this.lowPower = lowPower;
	}

	public String getUserName()
	{
		return userName;
	}

	public void setUserName(String userName)
	{
		this.userName = userName;
	}

	public int getReviewState()
	{
		return reviewState;
	}

	public void setReviewState(int reviewState)
	{
		this.reviewState = reviewState;
	}

	public String getRemark()
	{
		return remark;
	}

	public void setRemark(String remark)
	{
		this.remark = remark;
	}

	public int getProductId()
	{
		return productId;
	}


}
