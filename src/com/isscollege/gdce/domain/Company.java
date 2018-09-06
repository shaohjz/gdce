package com.isscollege.gdce.domain;

public class Company
{
	// 企业机构代码
	private String companyId;
	// 企业名称
	private String companyName;
	// 法人
	private String legalPerson;
	// 联系方式
	private String phoneNumber;
	// 银行账户
	private String bankAccount;
	// 营业执照
	private String openLicenseId;
	// 营业执照存放路径（/imgs/openLicense/企业机构代码+时间戳）
	private String openLicensePath;
	// 税务登记号
	private String taxRegisterId;
	// 审核状态 0-待审核 1-通过 2-未通过
	private int reviewState;

	public String getCompanyId()
	{
		return companyId;
	}

	public void setCompanyId(String companyId)
	{
		this.companyId = companyId;
	}

	public String getCompanyName()
	{
		return companyName;
	}

	public void setCompanyName(String companyName)
	{
		this.companyName = companyName;
	}

	public String getLegalPerson()
	{
		return legalPerson;
	}

	public void setLegalPerson(String legalPerson)
	{
		this.legalPerson = legalPerson;
	}

	public String getPhoneNumber()
	{
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber)
	{
		this.phoneNumber = phoneNumber;
	}

	public String getBankAccount()
	{
		return bankAccount;
	}

	public void setBankAccount(String bankAccount)
	{
		this.bankAccount = bankAccount;
	}

	public String getOpenLicenseId()
	{
		return openLicenseId;
	}

	public void setOpenLicenseId(String openLicenseId)
	{
		this.openLicenseId = openLicenseId;
	}

	public String getOpenLicensePath()
	{
		return openLicensePath;
	}

	public void setOpenLicensePath(String openLicensePath)
	{
		this.openLicensePath = openLicensePath;
	}

	public String getTaxRegisterId()
	{
		return taxRegisterId;
	}

	public void setTaxRegisterId(String taxRegisterId)
	{
		this.taxRegisterId = taxRegisterId;
	}

	public int getReviewState()
	{
		return reviewState;
	}

	public void setReviewState(int reviewState)
	{
		this.reviewState = reviewState;
	}

}
