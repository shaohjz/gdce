package com.isscollege.gdce.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.isscollege.gdce.dao.IContractDao;
import com.isscollege.gdce.dao.impl.ContractDaoImpl;
import com.isscollege.gdce.domain.Contract;
import com.isscollege.gdce.domain.Product;
import com.isscollege.gdce.service.IContractService;

public class ContractServiceImpl implements IContractService
{
	private IContractDao dao;

	public ContractServiceImpl()
	{
		dao = new ContractDaoImpl();
	}
	
	@Override
	public boolean addContract(Contract contract)
	{
		try
		{
			return dao.addContract(contract);
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	@Override
	public int updateState(Contract constract,String ID)
	{
	
		return dao.updateState(constract,ID);
	}

	@Override
	public List<Contract> querConstractById(String ID)
	{
	
		try
		{
			return dao.querConstractById(ID);
		} catch (SQLException e)
		{
			e.printStackTrace();
			return null;
		}

	}

	@Override
	public boolean updateProductStatezero(Product product)
	{
		try
		{
			return dao.updateProductStatezero(product);
		} catch (SQLException e)
		{

			e.printStackTrace();
		}
		return false;
	}

}
